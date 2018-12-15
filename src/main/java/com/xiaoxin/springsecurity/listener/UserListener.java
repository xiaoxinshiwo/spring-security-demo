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
public class UserListener extends AbstractAsyncEventListener {

	@Subscribe
	@AllowConcurrentEvents
	public void onUserRegister(UserRegisterEvent event) throws InterruptedException {
		// 休眠模拟耗时处理的情况
		Thread.sleep(5000L);
		// 简单的就打印日志
		log.info("user register {}",event.getUserId());
	}
}
