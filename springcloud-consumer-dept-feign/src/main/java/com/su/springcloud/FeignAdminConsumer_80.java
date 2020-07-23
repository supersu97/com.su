package com.su.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.su.springcloud"})

public class FeignAdminConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignAdminConsumer_80.class);
    }
}
