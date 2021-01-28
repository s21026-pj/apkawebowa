package com.zaliczenie.apkawebowa.repository;


import com.zaliczenie.apkawebowa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
