package com.xiaoxin.springsecurity.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiaoxin.springsecurity.model.UserInfo;
import com.xiaoxin.springsecurity.model.userinfo.UserInfoSo;
import com.xiaoxin.springsecurity.service.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:33
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("findByPage")
    public PageInfo<UserInfo> findByPage(@ModelAttribute UserInfoSo so) {

        return userInfoService.findByPage(so);
    }
}
