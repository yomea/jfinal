package com.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.instructExt.Demo;
import com.jfinal.instructExt.Now;
import com.jfinal.kit.StrKit;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.FREE_MARKER);
	}

	/**
	 * 指定路径
	 */
	@Override
	public void configRoute(Routes me) {
	
	}

	/**
	 * 可配置模板引擎
	 */
	@Override
	public void configEngine(Engine me) {
		me.addSharedFunction("/WEB-INF/template/template.html");
		me.addDirective("now", new Now());//可以在模板中#now使用
		me.addDirective("demo", new Demo());
		me.addSharedMethod(new StrKit());//共享StrKit类中的public方法
		me.addSharedObject("hello", "world");//#(hello)
		me.addSharedObject("str",new StrKit());
		
	}

	/**
	 * 扩展插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		
	}

	/**
	 * 这里定义全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));
	}

}
