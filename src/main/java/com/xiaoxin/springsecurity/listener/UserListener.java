package com.xiaoxin.springsecurity.listener;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.xiaoxin.springsecurity.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhangyongxin
 * @date 2018/12/14 10:27 AM
 */
@Component
@Slf4j
public class UserListener extends AbstractActionEventListener{

	@Subscribe
	public void onUserRegister(UserRegisterEvent event) {
		// TODO: 2018/12/14 调查为什么不异步执行
		// 简单的就打印日志
		log.info("user register {}",event.getUserId());
	}
}
