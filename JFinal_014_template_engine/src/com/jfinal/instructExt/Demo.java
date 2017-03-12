package com.jfinal.instructExt;

import java.io.Writer;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.expr.ast.ExprList;
import com.jfinal.template.stat.Scope;

public class Demo extends Directive {
	
	
	//对参数进行扩展
	@Override
	public void setExprList(ExprList exprList) {
		// TODO Auto-generated method stub
		super.setExprList(exprList);
	}

	//是否包含#end作为结束符
	@Override
	public boolean hasEnd() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void exec(Env env, Scope scope, Writer writer) {
		this.write(writer, "body 执行前。。。");
		stat.exec(env, scope, writer);//执行body
		this.write(writer, "body 执行后。。。");
		
	}

}
