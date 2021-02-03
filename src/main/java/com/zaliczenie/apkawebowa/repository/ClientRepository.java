package com.zaliczenie.apkawebowa.repository;

import com.zaliczenie.apkawebowa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    }
