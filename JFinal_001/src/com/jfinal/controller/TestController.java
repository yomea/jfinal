package com.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class TestController extends Controller {
	
	@ActionKey("/test")//配置了这个，那么会忽略me.add()中的第一个参数
	public void index() {
		
		this.renderFreeMarker("/haha.html");
		
	}

}
