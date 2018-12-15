package com.xiaoxin.springsecurity.config;

import com.google.common.eventbus.AsyncEventBus;
import com.xiaoxin.springsecurity.listener.AsyncEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangyongxin
 * @date 2018/12/14 11:21 AM
 */
@Component
@Slf4j
public class ApplicationReadyContextListener implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	private AsyncEventBus eventBus;

	@Autowired
	private List<AsyncEventListener> eventList = Collections.emptyList();

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		/**
		 * 注册eventBus
		 */
		for (AsyncEventListener asyncEventListener : eventList) {
			eventBus.register(asyncEventListener);
			log.info("eventBus register {}", asyncEventListener.getClass().getName());
		}
	}
}

