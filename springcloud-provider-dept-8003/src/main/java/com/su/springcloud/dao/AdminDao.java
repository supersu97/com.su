package com.su.springcloud.dao;

import com.su.springcloud.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminDao {
    boolean addAdmin(Admin admin);

    Admin queryById(int id);

    List<Admin> queryAll();
}
