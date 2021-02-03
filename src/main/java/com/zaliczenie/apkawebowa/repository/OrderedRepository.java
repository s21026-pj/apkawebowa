package com.zaliczenie.apkawebowa.repository;


import com.zaliczenie.apkawebowa.model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Long> {

}
