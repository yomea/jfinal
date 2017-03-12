package com.jfinal.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.entity.User;
import com.jfinal.kit.JMap;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

/**
 * @author may
 *
 */
public class UserController extends Controller {
	
	public void index() {
		
		Cache cache = Redis.use("redisTest");
		cache.set("user", User.dao.findById(1));
		Object value = cache.get("user");
		JMap map = JMap.create("a", "1").set("b", 2).set("c", 3);
		cache.hmset("user:list", map);
		List list = cache.hmget("user:list", "a", "b");
		
		
		// 最先创建的Cache将成为主Cache，所以可以省去cacheName参数来获取
		cache = Redis.use();  // 主缓存可以省去cacheName参数
		cache.set("jfinal", "awesome");
		
	}
	

}
