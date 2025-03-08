package com.rolandsall.kafka.template.config;

import com.rolandsall.kafka.template.OrderDomainService;
import com.rolandsall.kafka.template.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderService orderService(){
        return new OrderDomainService();
    }


}
