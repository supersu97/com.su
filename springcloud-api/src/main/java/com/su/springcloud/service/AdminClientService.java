package com.su.springcloud.service;

import com.su.springcloud.pojo.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "SPRING-CLOUD-DEPT")
@Component
public interface AdminClientService {

    @PostMapping("/admin/add")
    boolean addAdmin(Admin admin);

    @GetMapping("/admin/get/{id}")
    Admin queryById(@PathVariable("id") int id);

    @GetMapping("/admin/list")
    List<Admin> queryAll();
}
