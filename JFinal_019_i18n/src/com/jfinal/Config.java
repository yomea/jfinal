package com.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.i18n.I18nInterceptor;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.FREE_MARKER);
		me.setI18nDefaultBaseName("i18n");
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
	}

	@Override 
	public void configPlugin(Plugins me) {

	}

	/**
	 * 这里定义全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new I18nInterceptor());//配置了全局的i18n拦截器，就可以在页面中${_res.msg}
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));
	}

}
