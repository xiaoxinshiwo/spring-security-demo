package com.xiaoxin.springsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 成功登陆后跳转页面
 * @Auther zhangyongxin
 * @date 2018/6/23 下午1:11
 */
@RestController
public class IndexController {

    @RequestMapping("loginSuccess")
    public String loginSuccess(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return "Welcome "+userName;
    }
}
