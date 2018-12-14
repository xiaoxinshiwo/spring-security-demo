package com.xiaoxin.springsecurity.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册事件
 * @author zhangyongxin
 * @date 2018/12/14 10:36 AM
 */
@Data
@AllArgsConstructor
public class UserRegisterEvent implements Serializable {
	private static final long serialVersionUID = -6352782953925936750L;

	private String userId;
}
