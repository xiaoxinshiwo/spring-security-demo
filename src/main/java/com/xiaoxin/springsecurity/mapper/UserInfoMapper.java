package com.xiaoxin.springsecurity.mapper;

import com.xiaoxin.springsecurity.model.UserInfo;
import com.xiaoxin.springsecurity.model.userinfo.UserInfoSo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface UserInfoMapper extends Mapper<UserInfo> {

    UserInfo findByUsername(String username);

    List<UserInfo> findByPage(UserInfoSo so);
}