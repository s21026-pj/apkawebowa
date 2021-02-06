package com.zaliczenie.apkawebowa.repository;


import com.zaliczenie.apkawebowa.model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Long> {

    @Query("SELECT o FROM Ordered o  Where o.status=0")
    Collection<Ordered> findAllOpenOrders();
}
