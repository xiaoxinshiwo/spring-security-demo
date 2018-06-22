package com.xiaoxin.springsecurity.handler;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 异常处理
 *
 * @Auther zhangyongxin
 * @date 2018/6/20 下午3:59
 */
@Component
public class UnauthenticationExceptionHandler implements AuthenticationEntryPoint, Serializable {


    private static final long serialVersionUID = -1460229149976278508L;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        String message = "";
        int status = 0;
        if (e instanceof BadCredentialsException) {
            message = "username or password error";
            status = HttpServletResponse.SC_BAD_REQUEST;
        } else if (e instanceof InsufficientAuthenticationException) {
            message = "no access permission";
            status = HttpServletResponse.SC_FORBIDDEN;
        }
        httpServletResponse.sendError(status, message);

    }
}
