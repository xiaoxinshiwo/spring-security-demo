package com.xiaoxin.springsecurity.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

/**
 * 使用guava的eventBus进行事件监听
 * @author zhangyongxin
 * @date 2018-12-14 10:15:02
 */
@Configuration
public class EventBusConfig {

	@Bean
	public EventBus eventBus() {
		return new AsyncEventBus("springsecurity-demo-event",
				Executors.newFixedThreadPool(10));
	}


}
