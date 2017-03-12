package com.jfinal.controller;

import com.jfinal.core.Controller;
//(get方式)http://localhost:8888/JFinal_003_customRoute/username=root&password=root
public class Controller_2 extends Controller {
	
	public void index() {
		
		this.setAttr("msg", "请求成功！！！");
		//get方式
		System.out.println("GET方式" + this.getPara(0));
		System.out.println("GET方式" + this.getPara(1));
		System.out.println("----------------------------------------------------------------");
		//post方式
		System.out.println("POST方式" + this.getPara("username"));
		System.out.println("POST方式" + this.getPara("password"));
		//this.renderText("前台Controller_2！！！");
		this.renderFreeMarker("helloworld.html");
	}

}
