package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private BuyingService buyingService;

    public ProductService(ProductRepository productRepository, BuyingService buyingService){
        this.productRepository = productRepository;
        this.buyingService= buyingService;
    }

    public Product save (Product product){
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long ProductId){
        if (ProductId == 10L ){
            throw new RuntimeException();
        }else {
            Optional<Product> ById = productRepository.findById(ProductId);
            return ById;
        }
    }
    public Optional<Product> buy(Long ProductId, int amount){
        Product ById =  findById(ProductId).get();
        if (buyingService.buyProduct(ById, amount) != null) {
            ById = buyingService.buyProduct(ById,amount);
            return productRepository.save(ById);
        }else {
            return null;
        }
    }
}
