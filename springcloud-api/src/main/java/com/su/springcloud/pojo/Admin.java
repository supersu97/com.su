package com.su.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Admin implements Serializable {
    private int aid;
    private String username;
    private String password;

    private String db_source;

    public Admin(String username,String password){
        this.username = username;
        this.password = password;
    }
}
