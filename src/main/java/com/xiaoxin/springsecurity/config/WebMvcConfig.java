package com.xiaoxin.springsecurity.config;

import com.google.gson.Gson;
import com.xiaoxin.springsecurity.common.Result;
import com.xiaoxin.springsecurity.common.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/6/23 下午12:03
 */
@Configuration
@Slf4j
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add((httpServletRequest, httpServletResponse, handler, exception) -> {
            Result result =new Result();
            if(exception instanceof AccessDeniedException){
                result = new Result(HttpServletResponse.SC_FORBIDDEN,exception.getMessage());
            }else{
                result.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).setMessage("接口 [" + httpServletRequest.getRequestURI() + "] 内部错误，请联系管理员");
                String message;
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                            httpServletRequest.getRequestURI(),
                            handlerMethod.getBean().getClass().getName(),
                            handlerMethod.getMethod().getName(),
                            exception.getMessage());
                } else {
                    message = exception.getMessage();
                }
                log.error(message, exception);
            }
            try {
                httpServletResponse.getWriter().write(new Gson().toJson(result));
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
                httpServletResponse.setStatus(200);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ModelAndView();
        });
    }
}
