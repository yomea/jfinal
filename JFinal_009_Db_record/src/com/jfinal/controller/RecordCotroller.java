package com.jfinal.controller;

import java.sql.SQLException;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Record;

public class RecordCotroller extends Controller {

	public void index() {
		//MY_SEQ.nextval用于针对Oracle序列
		Record record = new Record().set("username", "admin").set("password", "admin").set("id", "MY_SEQ.nextval");

		Db.save("t_user", record);
		// Db.deleteById(tableName, idValue)MY_SEQ.nextval
		// Db.deleteById(tableName, primaryKey, idValue)
		//原子操作，事物操作
		boolean succeed = Db.tx(new IAtom() {

			@Override
			public boolean run() throws SQLException {
				int count = Db.update("update t_user set cash = cash - ? where id = ?", 100, 123);
				int count2 = Db.update("update t_user set cash = cash + ? where id = ?", 100, 456);
				return count == 1 && count2 == 1;
			}
		});
		
//		复合主键
//		Db.findById("user_role", "roleId, userId", 123, 456);
//		Db.deleteById("user_role", "roleId, userId", 123, 456);
		
		
	}
}
