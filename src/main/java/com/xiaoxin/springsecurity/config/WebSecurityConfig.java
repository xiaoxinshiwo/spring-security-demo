package com.xiaoxin.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * spring security核心配置
 * 开发环境下不生效
 * @Auther zhangyongxin
 * @date 2018/6/20 下午3:12
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userService;

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        if("prod".equals(profile)){
            httpSecurity.authorizeRequests()
                    // 需要忽略的，其他都要登录
                    .antMatchers("/ignore/**").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().defaultSuccessUrl("/loginSuccess", true);
        }else{
            httpSecurity.authorizeRequests().antMatchers("/**/**").permitAll();
        }
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.POST, "/auth")
                // allow anonymous resource requests
                .and().ignoring().antMatchers("/webjars/**","/swagger-ui.html", "/v2/**", "/swagger*/**","/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js");


    }

}
