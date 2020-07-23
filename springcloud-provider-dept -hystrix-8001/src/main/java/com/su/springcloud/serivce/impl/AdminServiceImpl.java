package com.su.springcloud.serivce.impl;

import com.su.springcloud.dao.AdminDao;
import com.su.springcloud.pojo.Admin;
import com.su.springcloud.serivce.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    public boolean addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    public Admin queryById(int id) {
        return adminDao.queryById(id);
    }

    public List<Admin> queryAll() {
        return adminDao.queryAll();
    }
}
