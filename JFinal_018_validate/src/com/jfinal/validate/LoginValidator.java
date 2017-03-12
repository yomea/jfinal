package com.jfinal.validate;

import com.jfinal.core.Controller;
import com.jfinal.entity.User;

public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("username", "nameMsg", "请输入用户名");
		validateRequiredString("userpassword", "passMsg", "请输入密码");
	}

	@Override
	protected void handleError(Controller c) {
		c.keepPara("username");//出错就保持用户输入的值，以便返回时能够保持当初输入的数据
		c.keepModel(User.class);
		c.render("login.html");

	}

}
