package com.xiaoxin.springsecurity.config;

import com.google.common.eventbus.EventBus;
import com.xiaoxin.springsecurity.listener.ActionEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangyongxin
 * @date 2018/12/14 10:55 AM
 */
//@Component
public class SystemApplicationRunner implements ApplicationRunner {

	@Autowired
	private EventBus eventBus;

	@Autowired
	private List<ActionEventListener> eventList = Collections.emptyList();

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/**
		 * 注册eventBus
		 */
			for(ActionEventListener actionEventListener : eventList){
				eventBus.register(actionEventListener);
			}
		}
	}
