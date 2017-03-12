#sql("findUser")
	select * from t_user where id=?
#end

#namespace("user")
#sql("findUser")
	update t_user set username=#(username) where id=#p(id)
#end


###定义通用模板函数
#define deleteByIdList(table, idList)

	delete from #(table) where id in (
		#for(id : idList)
			#(for.index > 0 ? "," : "") #(id)
		#end
	)
#end


###调用通用模板函数
#sql("deleteUsers")
	#@deleteByIdList("t_user", idList)
#end
	
	
	