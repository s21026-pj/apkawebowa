package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zaliczenie.apkawebowa.repository.ProductRepository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BuyingService buyingService;

    public ProductService(ProductRepository productRepository, BuyingService buyingService) {
        this.productRepository = productRepository;
        this.buyingService = buyingService;
    }

    public ProductService() {

    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long ProductId) {
        Optional<Product> ById = productRepository.findById(ProductId);
        return ById;
    }

    public Page<Product> filterByPrice(int pageNumber){
        Page<Product> allTenDollarProducts = productRepository.findAllByPriceGreaterThanEqual(10,PageRequest.of(pageNumber,4, Sort.by("price").ascending()));
        return allTenDollarProducts;
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public int sell(Long id, int amount) {
        Product soldItem= findById(id).get();
        if (soldItem.getAmount() >= amount ) {
            soldItem.setAmount(soldItem.getAmount() - amount);
            productRepository.save(soldItem);
            return soldItem.getAmount();
        } else {
            throw new IllegalArgumentException();
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

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
