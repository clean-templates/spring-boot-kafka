package com.rolandsall.kafka.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rolandsall.kafka.template")
public class OrderServiceLauncher {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceLauncher.class, args);
    }
}
