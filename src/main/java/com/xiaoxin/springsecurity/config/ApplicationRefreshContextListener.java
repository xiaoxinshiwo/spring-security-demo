package com.xiaoxin.springsecurity.config;

import com.google.common.eventbus.EventBus;
import com.xiaoxin.springsecurity.listener.ActionEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangyongxin
 * @date 2018/12/14 11:21 AM
 */
//@Component
@Slf4j
public class ApplicationRefreshContextListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private EventBus eventBus;

	@Autowired
	private List<ActionEventListener> eventList = Collections.emptyList();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
		if (applicationContext.getParent() != null) {
			/**
			 * 注册eventBus
			 */
			for (ActionEventListener actionEventListener : eventList) {
				eventBus.register(actionEventListener);
				log.info("eventBus register {}",actionEventListener);
			}
		}
	}

}

