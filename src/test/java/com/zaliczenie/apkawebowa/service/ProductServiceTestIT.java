package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
public class ProductServiceTestIT {

    @BeforeEach
    void cleanup(){
        productService.deleteAll();
    }

    @Autowired
    private ProductService productService;

    @Test
    void ifSellingMoreThanHaveShouldThrowException() {

        productService.save(new Product(1L,100));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->productService.sell(1L,110));
    }

    @Test
    void shouldNotFindById(){

        Optional<Product> foundById=productService.findById(1L);

        assertThat(foundById).isEmpty();
    }
}
