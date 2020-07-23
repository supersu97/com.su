package com.su.springcloud.controller;

import com.su.springcloud.pojo.Admin;
import com.su.springcloud.serivce.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    //获取一些配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/admin/add")
    public boolean addAdmin(Admin admin){
        return adminService.addAdmin(admin);
    }

    @GetMapping("/admin/get/{id}")
    public Admin queryById(@PathVariable("id") int id){
        return adminService.queryById(id);
    }

    @GetMapping("/admin/list")
    public List<Admin> queryAll(){
        return adminService.queryAll();
    }
}
