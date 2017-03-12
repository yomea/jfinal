package com.jfinal.controller;

import java.util.Date;

import com.jfinal.core.Controller;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;

/**
 * @author may Cron4jPlugin 是 JFinal 集成的任务调度插件，通过使用 Cron4jPlugin 可以使用通用的 cron
 *         表达式极为便利的实现任务调度功能。
 *
 */
public class UserController extends Controller {

	public void index() {
		
		
		// 通过locale参数en_US得到对应的Res对象
		Res resEn = I18n.use("en_US");
		// 直接获取数据
		String msgEn = resEn.get("msg");
		// 获取数据并使用参数格式化
		String msgEnFormat = resEn.format("msg", "james", new Date());
		// 通过locale参数zh_CN得到对应的Res对象
		Res resZh = I18n.use("zh_CN");
		// 直接获取数据
		String msgZh = resZh.get("msg");
		// 获取数据并使用参数格式化
		String msgZhFormat = resZh.format("msg", "詹波", new Date());
		// 另外,I18n还可以加载未使用me.setI18nDefaultBaseName()配置过的资源文件，唯一的不同是
		// 需要指定baseName参数，下面例子需要先创建otherRes_en_US.properties文件
		Res otherRes = I18n.use("otherRes", "en_US");
		otherRes.get("msg");
	}
			

}
