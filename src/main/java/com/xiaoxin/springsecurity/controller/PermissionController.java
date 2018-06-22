package com.xiaoxin.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置了需要权限的请求
 * @Auther zhangyongxin
 * @date 2018/6/20 下午4:12
 */
@RestController
@RequestMapping("permit")
public class PermissionController {

    @GetMapping("/needCreate")
    @PreAuthorize("authenticated and hasPermission(user-create)")
    public String needCreate() {
        return "admin created";
    }

    @GetMapping("/needUpdate")
    @PreAuthorize("hasPermission(user-update)")
    public String needUpdate(){
        return " user updated";
    }

    @GetMapping("/query")
    public String query(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format(" user returned '%s' ",userName);
    }
}
