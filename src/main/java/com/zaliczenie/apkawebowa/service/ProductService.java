package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private BuyingService buyingService;

    Pageable firstPageWithTwoElements = (Pageable) PageRequest.of(0,2);

    public ProductService(ProductRepository productRepository, BuyingService buyingService) {
        this.productRepository = productRepository;
        this.buyingService = buyingService;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long ProductId) {
        if (ProductId == 10L) {
            throw new RuntimeException();
        } else {
            Optional<Product> ById = productRepository.findById(ProductId);
            return ById;
        }
    }

    public Product partialUpdateById(Map<String, Object> updates, Long ProductId) {

        Product ById = findById(ProductId).get();

        if(updates.containsKey("productName")){
            ById.setProductName(String.valueOf(updates.get("productName")));
        }

        if(updates.containsKey("productMaker")){
            ById.setProductMaker(String.valueOf(updates.get("productMaker")));
        }

        if(updates.containsKey("description")){
            ById.setDescription(String.valueOf(updates.get("description")));
        }

        if(updates.containsKey("price")){
            ById.setPrice((Integer) updates.get("price"));
        }

        if(updates.containsKey("amount")){
            ById.setAmount((Integer) updates.get("amount"));
        }

        return productRepository.save(ById);
    }
}
