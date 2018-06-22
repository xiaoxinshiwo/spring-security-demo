package com.xiaoxin.springsecurity.config;

import com.xiaoxin.springsecurity.handler.UnauthenticationExceptionHandler;
import com.xiaoxin.springsecurity.handler.UserPasswordEncoder;
import com.xiaoxin.springsecurity.handler.UserPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Auther zhangyongxin
 * @date 2018/6/20 下午3:12
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userService;
    @Autowired
    private UnauthenticationExceptionHandler unauthorizedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(userPasswordEncoder());
    }

    @Bean
    public UserPasswordEncoder userPasswordEncoder() {
        return new UserPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    public DefaultMethodSecurityExpressionHandler expressionHandler(UserPermissionEvaluator permissionEvaluator) {
//        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
//        expressionHandler.setPermissionEvaluator(permissionEvaluator);
//        return expressionHandler;
//    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 异常处理
        httpSecurity.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and().authorizeRequests()
                // 需要忽略的，其他都要登录
                .antMatchers("/user/**").permitAll().antMatchers("/ignore/**").permitAll().anyRequest().authenticated();

    }

}
