package com.su.springcloud.controller;

import com.su.springcloud.pojo.Admin;
import com.su.springcloud.service.AdminClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AdminConsumerController {

    @Autowired
    private AdminClientService adminClientService;

    @RequestMapping("/consumer/admin/add")
    public boolean add(Admin admin){
        return this.adminClientService.addAdmin(admin);
    }

    @RequestMapping("/consumer/admin/get/{id}")
    public Admin get(@PathVariable("id") int id){
        return adminClientService.queryById(id);
    }

    @RequestMapping("consumer/admin/list")
    public List<Admin> list(){
        return adminClientService.queryAll();
    }
}
