package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.exceptions.NoSuchUserException;
import com.zaliczenie.apkawebowa.model.Ordered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zaliczenie.apkawebowa.repository.OrderedRepository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderedService {

    @Autowired
    private OrderedRepository orderedRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    AtomicLong seq = new AtomicLong();

    public OrderedService(OrderedRepository orderedRepository) {
        this.orderedRepository = orderedRepository;
    }

    public Ordered save(Ordered ordered) {
        return orderedRepository.save(ordered);
    }

    public boolean placeOrder(Long id,Ordered ordered) {
        if(productService.findById(id).isPresent()) {
            if (productService.findById(id).get().getAmount() - ordered.getOrderAmount() >= 0 && clientService.checkIfExistLogin(ordered.getCustomerLogin())) {
                productService.sell(id, ordered.getOrderAmount());
                ordered.setProductId(id);
                save(ordered);
                return true;
            }
        }
        return false;
    }

    public List<Ordered> finalizeOrder(Long customerId){
       Collection<Ordered> collectionOfOrders = orderedRepository.findAllOpenOrders();
       Long nextVal=seq.incrementAndGet();
       List<Ordered> summary=new ArrayList<>();

        for (Ordered order:collectionOfOrders) {
            order.setStatus(Ordered.Status.toPrepare);
            order.setFinalId(nextVal);
            summary.add(order);
        }
        return summary;
    }
    public Optional<Ordered> findById(Long orderedId) {
        Optional<Ordered> ById = orderedRepository.findById(orderedId);
        return ById;
    }
}
