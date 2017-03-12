package com.jfinal.entity;

import com.jfinal.plugin.activerecord.Model;

/**
 * 定义这个pojo为模型
 * @author may
 *
 */
public class User extends Model<User> {
	
	private static final long serialVersionUID = -3764715644025394142L;
	
	public static final User dao = new User().dao();///必须是static final的

}
