package com.example.contratservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContratServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContratServiceApplication.class, args);
        System.out.println("Hello Contrat Service");
    }

}
