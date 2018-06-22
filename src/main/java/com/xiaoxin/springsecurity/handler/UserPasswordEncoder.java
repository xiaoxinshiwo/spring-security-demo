package com.xiaoxin.springsecurity.handler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码加密器，一般使用MD5加密，本例原值返回
 * @Auther zhangyongxin
 * @date 2018/6/22 下午1:08
 */
@Component
public class UserPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
