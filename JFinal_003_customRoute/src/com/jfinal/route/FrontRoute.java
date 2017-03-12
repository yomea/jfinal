package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.Controller_1;
import com.jfinal.controller.Controller_2;

//http://localhost:8888/JFinal_003_customRoute/test_1
//(get方式)http://localhost:8888/JFinal_003_customRoute/username=root&password=root
public class FrontRoute extends Routes {

	@Override
	public void config() {
		this.setBaseViewPath("/WEB-INF/html");//配置HTML的位置
		this.add("/test_1", Controller_1.class);
		this.add("/", Controller_2.class);
		
	}

}
