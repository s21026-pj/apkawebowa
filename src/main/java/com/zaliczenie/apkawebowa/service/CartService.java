package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Cart;
import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.CartRepository;
import com.zaliczenie.apkawebowa.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;


    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }


    public Optional<Cart> findById(Long cartId) {

            Optional<Cart> ById = cartRepository.findById(cartId);
            return ById;
        }


//    public Product partialUpdateById(Map<String, Object> updates, Long ProductId) {
//
//        Product ById = findById(ProductId).get();
//
//        if(updates.containsKey("productName")){
//            ById.setProductName(String.valueOf(updates.get("productName")));
//        }
//
//        if(updates.containsKey("productMaker")){
//            ById.setProductMaker(String.valueOf(updates.get("productMaker")));
//        }
//
//        if(updates.containsKey("description")){
//            ById.setDescription(String.valueOf(updates.get("description")));
//        }
//
//        if(updates.containsKey("price")){
//            ById.setPrice((Integer) updates.get("price"));
//        }
//
//        if(updates.containsKey("amount")){
//            ById.setAmount((Integer) updates.get("amount"));
//        }
//
//        return cartRepository.save(ById);
//    }
}
