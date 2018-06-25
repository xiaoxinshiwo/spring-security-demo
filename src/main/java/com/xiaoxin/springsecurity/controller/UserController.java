package com.xiaoxin.springsecurity.controller;

import com.github.pagehelper.PageInfo;
import com.xiaoxin.springsecurity.model.UserInfo;
import com.xiaoxin.springsecurity.model.userinfo.UserInfoSo;
import com.xiaoxin.springsecurity.service.userinfo.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "根据查询条件分页", notes = "默认一页10条")
    public PageInfo<UserInfo> findByPage(@ModelAttribute UserInfoSo so) {

        return userInfoService.findByPage(so);
    }

    @GetMapping("find/{name}")
    @ApiOperation(value = "根据用户名称查询用户信息", notes = "根据用户名称查询用户信息")
    @ApiImplicitParam(name = "name", value = "用户name", required = true, dataType = "String", paramType = "path")
    public UserInfo findByPage(@PathVariable String name) {

        return userInfoService.findByName(name);
    }
}
