package com.example.firstserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FirstserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstserverApplication.class, args);
    }

}
