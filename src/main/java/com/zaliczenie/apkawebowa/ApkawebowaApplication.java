package com.zaliczenie.apkawebowa;

import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class ApkawebowaApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApkawebowaApplication.class, args);
    }

}
