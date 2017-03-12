package com.jfinal.intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MethodIntercept implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("method级别的拦截器");
		inv.invoke();
		System.out.println("method级别的拦截器");
		
	}

}
