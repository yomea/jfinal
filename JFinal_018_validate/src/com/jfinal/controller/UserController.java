package com.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.validate.LoginValidator;

/**
 * @author may Cron4jPlugin 是 JFinal 集成的任务调度插件，通过使用 Cron4jPlugin 可以使用通用的 cron
 *         表达式极为便利的实现任务调度功能。
 *
 */
public class UserController extends Controller {

	@Before(LoginValidator.class)//配置校验器
	public void login() {
		
	}

}
