package com.su.springcloud.controller;

import com.su.springcloud.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AdminConsumerController {
    //RestTemplate...供我们直接调用，注册到Spring中
    //(url,实体 map,Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的restful服务模板

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //Ribbon:我们这里的地址，应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-DEPT";

    @RequestMapping("/consumer/admin/add")
    public boolean add(Admin admin){
        return restTemplate.postForObject(REST_URL_PREFIX+"/admin/add",admin,Boolean.class);
    }

    @RequestMapping("/consumer/admin/get/{id}")
    public Admin get(@PathVariable("id") int id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/admin/get/"+id,Admin.class);
    }

    @RequestMapping("consumer/admin/list")
    public List<Admin> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/admin/list",List.class);
    }
}
