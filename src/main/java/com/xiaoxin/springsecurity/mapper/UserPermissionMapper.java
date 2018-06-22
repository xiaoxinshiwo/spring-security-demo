package com.xiaoxin.springsecurity.mapper;

import com.xiaoxin.springsecurity.model.UserPermission;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午8:16
 */
public interface UserPermissionMapper extends Mapper<UserPermission> {

    Set<UserPermission> findUserPermissions(String username);

}
