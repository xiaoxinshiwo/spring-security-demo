package com.xiaoxin.springsecurity.config;

import com.xiaoxin.springsecurity.handler.UserPermissionEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;

/**
 * @Auther zhangyongxin
 * @date 2018/6/23 上午11:51
 */
@Configuration
public class WebSecurityMethodConfig {

    @Bean
    public DefaultMethodSecurityExpressionHandler expressionHandler(UserPermissionEvaluator permissionEvaluator) {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(permissionEvaluator);
        return expressionHandler;
    }

}
