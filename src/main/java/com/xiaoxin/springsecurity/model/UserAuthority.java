package com.xiaoxin.springsecurity.model;

import com.google.common.base.Objects;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * 用户权限
 * @Auther zhangyongxin
 * @date 2018/6/20 下午4:29
 */
public class UserAuthority implements GrantedAuthority,Serializable {

    private static final long serialVersionUID = -7087837798687466404L;

    private String authority;

    private String remark;

    public UserAuthority(String authority, String remark) {
        this.authority = authority;
        this.remark = remark;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthority that = (UserAuthority) o;
        return Objects.equal(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(authority);
    }
}
