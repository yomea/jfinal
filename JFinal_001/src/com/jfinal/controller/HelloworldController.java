package com.jfinal.controller;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import com.jfinal.core.Controller;

public class HelloworldController extends Controller {
	
	//http://localhost:8888/JFinal_001
	public void index() {
		
		this.renderFreeMarker("helloworld.html");
	}
	
	
	//http://localhost:8888/JFinal_001/test
	public void test() {
		
		this.renderFreeMarker("test.html");
	}
	
	//http://localhost:8888/JFinal_001/geturlPara/urlPara-I am a urlPara
	public void geturlPara() throws UnsupportedEncodingException {
		String urlPara_1 = this.getPara(0);
		String urlPara_2 = URLDecoder.decode(this.getPara(1), "utf-8");
		System.out.println("接收的参数为：" + urlPara_1 + "和" + urlPara_2);
		this.renderFreeMarker("test.html");
	}

}
