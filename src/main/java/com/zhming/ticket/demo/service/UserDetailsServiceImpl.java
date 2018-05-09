package com.zhming.ticket.demo.service;

import com.zhming.ticket.demo.entity.SysUser;
import com.zhming.ticket.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysuser = userService.findByUsername(username);
        if(sysuser == null){
            throw new UsernameNotFoundException("用户名:"+username +"不存在");
        }
        return sysuser;
    }
}
