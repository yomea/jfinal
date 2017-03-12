package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.Controller_3;
import com.jfinal.controller.Controller_4;
import com.jfinal.intercept.MyIntercept;

public class AdminRoute extends Routes {

	@Override
	public void config() {
		this.setBaseViewPath("/view/route");
		this.addInterceptor(new MyIntercept());
		this.add("/test_3", Controller_3.class);
		this.add("/test_4", Controller_4.class);
		
	}

}
