package com.zaliczenie.apkawebowa.repository;


import com.zaliczenie.apkawebowa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByPrice(int price, Pageable pageable);
}
