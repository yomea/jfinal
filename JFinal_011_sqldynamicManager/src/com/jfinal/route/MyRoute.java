package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.intercept.RouteInterceptor;

public class MyRoute extends Routes {

	@Override
	public void config() {
		
		this.addInterceptor(new RouteInterceptor());
		//添加路由
		//this.add(controllerKey, controllerClass)
		
	}

	

}
