package com.jfinal.controller;

import com.jfinal.core.Controller;

public class HelloworldController extends Controller {
	
	
	public void index() {
		
		this.renderText("Hello world!!!");
	}

}
