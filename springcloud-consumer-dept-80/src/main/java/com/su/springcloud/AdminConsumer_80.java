package com.su.springcloud;

import com.su.myrule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能够加载自定义的Ribbon类
@RibbonClient(name = "SPRING-CLOUD-DEPT",configuration = MyRibbonRule.class)
public class AdminConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(AdminConsumer_80.class);
    }
}
