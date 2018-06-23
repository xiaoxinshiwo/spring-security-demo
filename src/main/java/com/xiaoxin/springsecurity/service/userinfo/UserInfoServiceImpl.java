package com.xiaoxin.springsecurity.service.userinfo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxin.springsecurity.mapper.UserInfoMapper;
import com.xiaoxin.springsecurity.model.UserInfo;
import com.xiaoxin.springsecurity.model.userinfo.UserInfoSo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:37
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    @Override
    public PageInfo<UserInfo> findByPage(UserInfoSo so) {
        PageHelper.startPage(so.getCurrentPage(), so.getPageSize(),so.isEnableCount());
        List<UserInfo> userInfoList = userInfoMapper.findByPage(so);
        return new PageInfo(userInfoList);
    }
}
