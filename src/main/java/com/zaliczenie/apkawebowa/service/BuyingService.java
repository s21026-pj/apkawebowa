package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyingService {

    private ProductRepository productRepository;

    public BuyingService() {

    }

    public BuyingService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product buyProduct(Product product, int soldAmount) {
        if (product.getAmount() > soldAmount) {
            product.setAmount(product.getAmount() - soldAmount);
        } else {
            return null;
        }
        return product;
    }
}
