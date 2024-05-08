package com.example.assuranceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AssuranceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssuranceServiceApplication.class, args);
    }

}
