package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Ordered;
import com.zaliczenie.apkawebowa.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderedServiceTestIt {

    @Autowired
    private OrderedService orderedService;
    @Autowired
    private ProductService productService;

    @Test
    void ifSellingToNonexistentUserShouldReturnFalse() {
        //given

        //when
        productService.save(new Product(1L, 100));
        //than
        assertThat(orderedService.placeOrder(1L, new Ordered(10, 1L, "Fake"))).isFalse();
    }
}