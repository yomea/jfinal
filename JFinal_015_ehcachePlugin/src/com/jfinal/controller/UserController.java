package com.jfinal.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.entity.User;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.jfinal.plugin.ehcache.IDataLoader;

/**
 * @author may
 *
 */
public class UserController extends Controller {
	
	public void index() {
		//如果存在直接返回，如果不存在就执行IDataLoader中逻辑
		CacheKit.get("60time", "user", new IDataLoader() {
			
			@Override
			public Object load() {
				
				return User.dao.find("select * from t_user");
			}
		});
		
		
	}
	
	@Before(CacheInterceptor.class)
	@CacheName("60time")
	public void list() {
		
		List<User> users = User.dao.find("select * from t_user");
		setAttr("uses", users);//设置了CacheInterceptor拦截器就会自动缓存，下次请求这个action时，如果缓存里有，那么就不会执行这个action
		render("userList.html");
		
	}
	
	@Before(EvictInterceptor.class)//清空缓存
	@CacheName("60time")
	public void updateUser() {
		
		User.dao.update();
		redirect("userList.html");
	}


}
