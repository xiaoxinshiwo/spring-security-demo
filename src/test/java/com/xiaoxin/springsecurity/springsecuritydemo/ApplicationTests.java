package com.xiaoxin.springsecurity.springsecuritydemo;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.xiaoxin.springsecurity.event.UserRegisterEvent;
import com.xiaoxin.springsecurity.listener.UserListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	@Autowired
	private UserListener userListener;
	@Test
	public void contextLoads() {
	}

	@Test
	public void eventBusTest(){
		EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
		eventBus.register(userListener);
		eventBus.post(new UserRegisterEvent("1212"));
		log.info("3333");
	}
}
