package com.xiaoxin.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录
 *
 * @Auther zhangyongxin
 * @date 2018/6/20 下午4:54
 */
@RestController
@RequestMapping("")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/auth")
    public String auth(@RequestParam String userName, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        return "login success";
    }

}
