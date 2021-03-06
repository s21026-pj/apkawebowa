package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void schouldfindById() {
        //given
        when(productRepository.findById(1L)).thenReturn(Optional.of(new Product(1L)));
        //when
        Optional<Product> ByIdTest = productService.findById(1L);
        //than
        assertThat(ByIdTest.get().getId()).isEqualTo(1L);
    }


    @Test
    void ifSellingMoreThanHaveShouldThrowException() {
        //given
        when(productService.findById(1L)).thenReturn(Optional.of(new Product(1L, 100)));
        //when

        //than
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> productService.sell(1L, 110));
    }
}