package com.jfinal.intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Inject 拦截器是指在使用 enhance 或 duang 方法增强时使用参数传入的拦截器。
 * Inject 可以 对目标完全无侵入地应用 AOP。
 * 
 * @author may
 *
 */
public class InjectInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("我是inject拦截器");
		inv.invoke();
		System.out.println("我是inject拦截器");

	}

}
