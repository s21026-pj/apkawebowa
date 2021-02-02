package com.zaliczenie.apkawebowa.repository;


import com.zaliczenie.apkawebowa.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByPriceGreaterThanEqual(int price, Pageable pageable);


    Pageable firstPageWithFourElements = PageRequest.of(0, 4, Sort.by("price").ascending());


}
