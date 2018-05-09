package com.zhming.ticket.repository;

import com.zhming.ticket.demo.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {

    public SysUser findByUsername(String username){
        return new SysUser(username,"password");
    }
}
