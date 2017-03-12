package com.jfinal.controller;

import java.util.List;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.entity.User;
import com.jfinal.plugin.activerecord.Page;

public class UserController extends Controller {
	
	
	
	public void index() {
		
		renderFreeMarker("/WEB-INF/user/adduser.html");
		
	}
	
	
	public void addUser() {
		
		User user= this.getModel(User.class);
		boolean flag = user.dao().save();
		if(flag) {
			renderText("添加成功！");
			
		} else {
			renderText("添加失败！");
		}
		
	}
	
	@ActionKey("/users")
	public void queryUser() {
		//this.getModel(User.class, "user");
		User user = this.getModel(User.class);
		String sqlPara = "select * from t_user order by id desc";
		List<User> users = user.dao().find(sqlPara);
//		int pageNumber = this.getParaToInt(0);
//		int pageSize = this.getParaToInt(1);
//		Page<User> page = user.dao().paginate(pageNumber, pageSize, "select *", "from t_user");
//
//		users = page.getList();
		this.setAttr("users", users);
		renderFreeMarker("/WEB-INF/user/users.html");
		
	}
	
	public void deleteUser() {
		User user= this.getModel(User.class);
		user.dao().delete();
		
			
	}
	
	public void updateUser() {
		User user= this.getModel(User.class);
		user.dao().update();
	}
	
}