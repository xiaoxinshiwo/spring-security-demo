package com.xiaoxin.springsecurity.controller;

import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 配置了需要权限的请求
 * @Auther zhangyongxin
 * @date 2018/6/20 下午4:12
 */
@RestController
@RequestMapping("permit")
public class PermissionController {

    @GetMapping("/needCreate")
    @PreAuthorize("hasPermission('user','user:create')")
    public String needCreate() {
        return "admin created";
    }

    @GetMapping("/needUpdate")
    @PostAuthorize("hasPermission('user','user:update')")
    public String needUpdate(){
        return " user updated";
    }

    @GetMapping("/query")
    public String query(HttpServletRequest request){
        // from security
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        // from request
        userName = request.getUserPrincipal().getName();
        return String.format(" user returned '%s' ",userName);
    }
}
