package com.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.plugin.redis.RedisPlugin;
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
	}

	/**
	 * 扩展插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		me.add(new RedisPlugin("redisTest", "192.168.243.128", "7000"));
		me.add(new RedisPlugin("redis", "192.168.243.128", "7001"));
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
