package com.jfinal.intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ServiceInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("我被定义成service拦截器");
		inv.invoke();
		System.out.println("我被定义成service拦截器");
	}

}
