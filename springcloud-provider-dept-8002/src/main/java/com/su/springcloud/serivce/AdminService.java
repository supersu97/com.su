package com.su.springcloud.serivce;

import com.su.springcloud.pojo.Admin;

import java.util.List;

public interface AdminService {
    boolean addAdmin(Admin admin);

    Admin queryById(int id);

    List<Admin> queryAll();
}
