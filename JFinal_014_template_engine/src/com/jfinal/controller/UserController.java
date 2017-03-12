package com.jfinal.controller;

import com.jfinal.Istringsource.MyStringSource;
import com.jfinal.core.Controller;
import com.jfinal.kit.JMap;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.render.RenderManager;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;

/**
 * Engine 对象的创建方式有两种，一种是通过 Engine.create(…)方法，另一种是直接使用 new Engine(…)语句，前者创建的对象是在
 * Engine 模块管辖之内，可以通过 Engine.use(…)获取到， 而后者创建的对象脱离了 Engine 模块管辖，无法通过
 * Engine.use(…)获取到，开发者需要自行 管理。
 * 
 * 
 * JFinal 的 render 模块以及 activerecord 模块使用 new Engine(…)创建实例，无法通过
 * Engine.use(…)获取到，前者可以通过 RenaerManager.me().getEngine()获取到，后者可以通过
 * DbKit.getConfig().getSqlKit().getEngine()或者
 * activeRecordPlugin.getEngine()获取到。 Engine 对象管理的设计，允许在同一个应用程序中独立且自由地使用多个
 * Engine 实例， JFinal 自身的 render、activerecord 对 Engine 的独立使用就是典型的例子。这个设计还使开发者
 * 不仅可以利用官方提供的 create、use 方法来创建和使用 Engine 对象，而且还可以通过 new
 * Engine(…)的方式来创建更为自由、游离的对象自行去管理，有利于实现更为独立的模块功能。
 * 
 * @author may
 *
 */
public class UserController extends Controller {

	public void basicUser() {
		// JMap.create("K", "V")表示传到这个模板页面的参数
		String str = Engine.use().getTemplate("/WEB-INF/template/now.html").renderToString(JMap.create("K", "V"));
		renderText(str);
	}

	public void advanceUser() {
		// JMap.create("K", "V")表示传到这个模板页面的参数
		Engine engine = Engine.create("advance");
		Template template = engine.getTemplate("/WEB-INF/template/now.html");
		engine.setBaseTemplatePath("/WEB-INF/template/");
		String str = template.renderToString(JMap.create());
		// template.render(data, writer);//可以写到任何输出流中
		engine = Engine.use("advance");
		renderText(str);
	}

	// 非常适合用于替换 JDK 中的 String.format(…)方法。
	public void otherUser_1() {
		Engine engine = Engine.create("StringEngine");
		Template template = engine.getTemplateByString("#(x+1)");
		String str = template.renderToString(JMap.create("x", "1"));
		renderText(str);

	}

	public void otherUser_2() {
		Engine engine = Engine.create("StringEngine");
		Template template = engine.getTemplate(new MyStringSource());
		String str = template.renderToString(JMap.create("x", "1"));
		renderText(str);

	}
	
	public void engine() {
		RenderManager.me().getEngine();//获得render解析引擎
		DbKit.getConfig().getSqlKit().getEngine();//获得avtiveRecordPlugin解析引擎
	}

}
