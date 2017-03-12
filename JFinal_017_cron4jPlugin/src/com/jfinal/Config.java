package com.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
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
	 * /**
 * Cron4jPlugin 封装 cron4j，使用 cron 表达式调试 Task 执行
 *
 * cron 表达式由五部分组成：分 时 天 月 周
 * 分 ：从 0 到 59
 * 时 ：从 0 到 23
 * 天 ：从 1 到 31，字母 L 可以表示月的最后一天
 * 月 ：从 1 到 12，可以别名：jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov" and "dec"
 * 周 ：从 0 到 6，0 表示周日，6 表示周六，可以使用别名： "sun", "mon", "tue", "wed", "thu", "fri" and "sat"
 *
 * 数字 n：表示一个具体的时间点，例如 5 * * * * 表示 5 分这个时间点时执行
 * 逗号 , ：表示指定多个数值，例如 3,5 * * * * 表示 3 和 5 分这两个时间点执行
 * 减号 -：表示范围，例如 1-3 * * * * 表示 1 分、2 分再到 3 分这三个时间点执行
 * 星号 *：表示每一个时间点，例如 * * * * * 表示每分钟执行
 * 除号 /：表示指定一个值的增加幅度。例如 n/m表示从 n 开始，每次增加 m 的时间点执行
 *
 * 一、配置文件用法
 * cp = new Cron4jPlugin("cron4j.txt");
 * me.add(cp);
 *
 * 配置文件：
 * cron4j=task1, task2
 * task1.cron=* * * * *
 * task1.class=com.xxx.TaskAaa
 * task1.daemon=true
 * task1.enable=true
 *
 * task2.cron=* * * * *
 * task2.class=com.xxx.TaskBbb
 * task2.daemon=true
 * task2.enable=false
 *
 * cron4j 是所有配置的入口，用来配置有哪些 task 需要被调度，多个任务名称可用逗号分隔，例如上例中的 task1、task2
 * 后面的配置项均以 task1、task2 为前缀进行配置，具体意义如下
 * task1.cron 表示 task1 使用 cron 表达式调试任务
 * task1.class 表示 执行任务的类文件
 * task1.daemon 表示调试线程是否设置为守护线程，默认值为 true，守护线程会在 tomcat 关闭时自动关闭
 * task1.enable 表示该任务是否有效，默认值为 true，为 false 时该任务无效，不会被调用
 * task2 的配置与 task1 类似，不在赘述
 *
 * 此外：cron4j 这个配置项入口可以在 new Cron4jPlugin(...) 时指定，例如下面的代码将指定配置项入口为 "myCron4jConfig"
 * Cron4jPlugin("config.txt", "myCron4jConfig")，当指定配置入口为 "myCron4jConfig" 以后，配置就变成了如下的形式：
 * myCron4jConfig=task1, task2
 * 后面的配置完全不变
 *
 * 二、java 代码用法用法
 * cp = new Cron4jPlugin();
 * cp.addTask("* * * * *", new MyTask());
 * me.add(cp);
 * 还需要添加：schedule(Task task) 功能
 * 官方的例子证明可以调用系统的脚本，这个对于调用数据库备份来说很方便：
 *
 * 三、ProcessTask 调用系统程序的用法(How to schedule a system process)
 * System processes can be easily scheduled using the ProcessTask class:
 * ProcessTask task = new ProcessTask("C:\\Windows\\System32\\notepad.exe");
 * Scheduler scheduler = new Scheduler();
 * scheduler.schedule("* * * * *", task);
 * scheduler.start();
 *
 * Arguments for the process can be supplied by using a string array instead of a single command string:
 * String[] command = { "C:\\Windows\\System32\\notepad.exe", "C:\\File.txt" };
 * ProcessTask task = new ProcessTask(command);
 *
 * Environment variables for the process can be supplied using a second string array, whose elements have to be in the NAME=VALUE form:
 * String[] command = { "C:\\tomcat\\bin\\catalina.bat", "start" };
 * String[] envs = { "CATALINA_HOME=C:\\tomcat", "JAVA_HOME=C:\\jdks\\jdk5" };
 * ProcessTask task = new ProcessTask(command, envs);
 *
 * The default working directory for the process can be changed using a third parameter in the constructor:
 * String[] command = { "C:\\tomcat\\bin\\catalina.bat", "start" };
 * String[] envs = { "CATALINA_HOME=C:\\tomcat", "JAVA_HOME=C:\\jdks\\jdk5" };
 * File directory = "C:\\MyDirectory";
 * ProcessTask task = new ProcessTask(command, envs, directory);
 *
 * If you want to change the default working directory but you have not any environment variable, the envs parameter of the constructor can be set to null:
 * ProcessTask task = new ProcessTask(command, null, directory);
 */
	@Override 
	public void configPlugin(Plugins me) {

		Cron4jPlugin cron = new Cron4jPlugin("cron.txt", "cronName");
		// 与Linux中crontab命令一样，分 时 天 月 周
		/**
		 * 5 * * * * 表示 5 分这个时间点时执行 3,5 * * * * 表示 3 和 5 分这两个时间点执行 1-3 * * * *
		 * 表示 1 分、2 分再到 3 分这三个时间点执行 * * * * * 表示每分钟执行 n/m 表示从 n 开始，每次增加 m 的时间点执行
		 * 以上规则不是 JFinal 创造的，是通用的 cron 表达式规则，如果开发者本身具有这方面的 知识，用起来会得心应手。
		 */
		//纯java代码实现
		cron.addTask("* * * * *", new Runnable() {

			@Override
			public void run() {
				System.out.println("Cron4jPlugin 任务调度");

			}
		});
		//
		
		me.add(cron);
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
