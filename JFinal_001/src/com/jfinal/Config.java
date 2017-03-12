package com.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.controller.HelloworldController;
import com.jfinal.controller.TestController;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		this.loadPropertyFile("jdbc.txt");// 加载数据库配置文件
		me.setDevMode(this.getPropertyToBoolean("jdbc.devMode", true));// 设置是否为开发模式
		me.setViewType(ViewType.FREE_MARKER);// 设置视图类型
		me.setUrlParaSeparator("-");// 设置多个参数的分隔符，默认就是“-”。

	}

	/**
	 * 指定路径
	 */
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		// 配置路径，请求URL为http://localhost:8888/JFinal_001/
		/**
		 * 如下代码配置了将”/hello”映射到 HelloController 这个控 制 器 ， 通 过 以 下 的 配 置 ，
		 * http://localhost/hello 将 访 问 HelloController.index() 方 法 ， 而
		 * http://localhost/hello/methodName 将访问到
		 * HelloController.methodName()方法。
		 */
		// me.setBaseViewPath("/view");
		// 最终视图路径finalView = baseViewPath + viewPath + view
		// 注意当 ：当 view 以 “/” 字符 打头时 表示绝对路径， ，baseViewPath 与 viewPath 将被忽略。
		// me.add("/", HelloworldController.class);
		/**
		 * 如果配置了第三个参数，如果controller中写的是this.renderFreeMarker("haha.html");
		 * 那么它会/xixi/haha.html去找HTML，如果为this.renderFreeMarker("/haha.html");那么将忽略这边所有的配置，路径为/haha.html
		 */
		me.add("/haha", TestController.class, "/xixi");//
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new ContextPathHandler("contextPath"));// 配置上下文

	}

}
