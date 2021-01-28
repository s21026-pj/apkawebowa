package com.zaliczenie.apkawebowa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
