package com.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.controller.UserController;
import com.jfinal.controller.Yes;
import com.jfinal.entity.User;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		// this.loadPropertyFile(file)
		PropKit.use("jdbc.txt");
		me.setDevMode(true);
		// me.setUrlParaSeparator("&");
	}

	/**
	 * 指定路径
	 */
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		// me.add(new FrontRoute());
		// me.add(new AdminRoute());
		me.add("/user", UserController.class);
		me.add("/index", Yes.class);

	}

	/**
	 * 可配置模板引擎
	 */
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	/**
	 * 扩展插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		DruidPlugin druid = new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.username"),
				PropKit.get("jdbc.password"), PropKit.get("jdbc.driverClassName"));
		me.add(druid);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druid);
		me.add(arp);
		arp.addMapping("t_user", User.class);
		
	}

	/**
	 * 这里定义全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new ContextPathHandler("contextPath"));
	}

}
