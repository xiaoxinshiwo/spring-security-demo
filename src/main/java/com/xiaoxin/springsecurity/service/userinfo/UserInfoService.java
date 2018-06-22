package com.xiaoxin.springsecurity.service.userinfo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiaoxin.springsecurity.model.UserInfo;
import com.xiaoxin.springsecurity.model.userinfo.UserInfoSo;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:35
 */
public interface UserInfoService {

    PageInfo<UserInfo> findByPage(UserInfoSo so);
}
