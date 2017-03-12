package com.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.entity.User;
import com.jfinal.kit.JMap;
import com.jfinal.plugin.activerecord.SqlPara;

public class UserController extends Controller {
	
	public void addUser() {
		//调用这个方法就可以获得页面传过来的参数
		this.getModel(User.class);
		User.dao.save();
	}
	
	public void queryUser() {
		
		
		/**
		 * #sql("findUser")
			select * from t_user where id=?
			#end
		 */
		User.dao.find(User.dao.getSql("queryUser"), 1);
		
		JMap con  = JMap.create("id", 1).set("username", "hehe");
	
		/**
		 * #namespace("user")
			#sql("findUser")
				update t_user set username=#(username) where id=#p(id)
			#end
			
			
			#p(id)表示从map中寻找属性名为id的对应的值
			#(username)会直接这个变量对应的值输出
		 */
		SqlPara sqlPara = User.dao.getSqlPara("user.findUser", con);
		
		User.dao.find(sqlPara);
	}

}
