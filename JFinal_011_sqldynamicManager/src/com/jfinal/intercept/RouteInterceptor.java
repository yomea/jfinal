package com.jfinal.intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class RouteInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("我是URL级别的拦截器");
		inv.invoke();
		System.out.println("我是URL级别的拦截器");
	}

}
