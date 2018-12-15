package com.xiaoxin.springsecurity.controller;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.xiaoxin.springsecurity.common.Result;
import com.xiaoxin.springsecurity.common.ResultGenerator;
import com.xiaoxin.springsecurity.event.UserRegisterEvent;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyongxin
 * @date 2018/12/14 10:41 AM
 */
@RestController
@RequestMapping("eventbus")
public class EventBusTestController {

	@Autowired
	private AsyncEventBus eventBus;

	@GetMapping("{userId}")
	@ApiOperation(value = "eventBus测试", notes = "eventBus测试")
	public Result testUserRegister(String userId){
		UserRegisterEvent event = new UserRegisterEvent(userId);
		eventBus.post(event);
		return ResultGenerator.genSuccessResult();
	}
}
