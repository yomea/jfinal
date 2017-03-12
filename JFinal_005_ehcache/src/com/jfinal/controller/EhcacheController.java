package com.jfinal.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.entity.User;
import com.jfinal.plugin.ehcache.CacheKit;

public class EhcacheController extends Controller {

	public void index() {
		User user = this.getModel(User.class);
	    Map<String, Object> indexMap= CacheKit.get("60time", "user");
	    if (indexMap== null) {
	          indexMap=new HashMap<String, Object>();
	          indexMap.put("user",user.dao().findById(1));
	          CacheKit.put("60time", "user", indexMap);
	    }
	   // setAttr("user", indexMap);
	    renderText("");
	}
	
	
}
