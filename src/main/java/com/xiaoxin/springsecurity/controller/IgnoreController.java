package com.xiaoxin.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置了被忽略的请求
 * @Auther zhangyongxin
 * @date 2018/6/20 下午4:10
 */
@RestController
@RequestMapping("ignore")
public class IgnoreController {

    @GetMapping("/hi")
    public String hi(){
        return "ignored";
    }
}
