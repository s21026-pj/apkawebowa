package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Ordered;
import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.OrderedRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderedServiceTestIt {

    @Autowired
    private OrderedService orderedService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ClientService clientService;

    @Test
    void ifSellingToNonexistentUserShouldReturnFalse() {
        //given

        //when
        productService.save(new Product(1L,100));
        //than
        assertThat(orderedService.placeOrder(1L,new Ordered(10,1L,"Fake"))).isFalse();
    }
}