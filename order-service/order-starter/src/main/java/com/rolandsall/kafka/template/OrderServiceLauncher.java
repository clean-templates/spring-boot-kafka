package com.rolandsall.kafka.template;

import com.rolandsall.kafka.template.mediator.EnableMediator4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rolandsall.kafka.template")
@EnableMediator4j
public class OrderServiceLauncher {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceLauncher.class, args);
    }
}
