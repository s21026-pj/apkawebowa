package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Ordered;
import org.springframework.stereotype.Service;
import com.zaliczenie.apkawebowa.repository.OrderedRepository;


import java.util.Optional;

@Service
public class OrderedService {

    private OrderedRepository orderedRepository;

    public OrderedService(OrderedRepository orderedRepository) {
        this.orderedRepository = orderedRepository;
    }

    public Ordered save(Ordered ordered) {
        return orderedRepository.save(ordered);
    }

    public Optional<Ordered> findById(Long orderedId) {
        Optional<Ordered> ById = orderedRepository.findById(orderedId);
        return ById;
    }
}
