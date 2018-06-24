package com.xiaoxin.springsecurity.controller;

import com.xiaoxin.springsecurity.model.User;
import com.xiaoxin.springsecurity.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录
 *
 * @Auther zhangyongxin
 * @date 2018/6/20 下午4:54
 */
@RestController
@RequestMapping("")
public class LoginController {
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;


    @PostMapping("/auth")
    public String auth(@RequestBody UserInfo user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        return "login success";
    }

}
