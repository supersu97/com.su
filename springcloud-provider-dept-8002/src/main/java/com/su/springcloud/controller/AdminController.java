package com.su.springcloud.controller;

import com.su.springcloud.pojo.Admin;
import com.su.springcloud.serivce.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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

    //注册进来的微服务，获取一些消息
    @GetMapping("/admin/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println(services);

        //得到一个具体的微服务
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()+"\t"
            );
        }
        return this.client;
    }
}
