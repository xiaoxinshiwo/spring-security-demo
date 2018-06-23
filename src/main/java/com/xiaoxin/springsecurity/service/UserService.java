package com.xiaoxin.springsecurity.service;

import com.google.common.collect.Sets;
import com.xiaoxin.springsecurity.mapper.UserInfoMapper;
import com.xiaoxin.springsecurity.mapper.UserPermissionMapper;
import com.xiaoxin.springsecurity.model.User;
import com.xiaoxin.springsecurity.model.UserAuthority;
import com.xiaoxin.springsecurity.model.UserInfo;
import com.xiaoxin.springsecurity.model.UserPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * 用户，用户权限获得服务
 *
 * @Auther zhangyongxin
 * @date 2018/6/20 下午3:32
 */
@Component
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    @Autowired(required = false)
    private UserPermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoMapper.findByUsername(name);
        User user;
        if (userInfo == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", name));
        }
        user = new User(userInfo.getUsername(), userInfo.getPassword());
        Set<UserPermission> permissionSet = permissionMapper.findUserPermissions(name);
        Set<UserAuthority> userAuthorities = Sets.newHashSetWithExpectedSize(permissionSet.size());
        if (!CollectionUtils.isEmpty(permissionSet)) {
            for (UserPermission permission : permissionSet) {
                UserAuthority userAuthority = new UserAuthority(permission.getPermission(), permission.getName());
                userAuthorities.add(userAuthority);
            }
            user.setAuthorities(userAuthorities);
        }
        log.info("user found with username {}.",name);
        return user;
    }
}
