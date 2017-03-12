package com.jfinal.controller;

import java.sql.SQLException;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.entity.User;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;

@Before(Tx.class)
public class RecordCotroller extends Controller {

	public void index() {

		Record record = new Record().set("username", "admin").set("password", "admin");

		Db.save("t_user", record);
		// Db.deleteById(tableName, idValue)
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
	}
}
