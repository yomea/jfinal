package com.jfinal.intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MyIntercept implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("拦截前。。。。。");
		inv.invoke();
		System.out.println("拦截后。。。。。");
		
	}

}
