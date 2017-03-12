package com.jfinal.instructExt;

import java.io.Writer;
import java.util.Date;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.stat.Scope;

/**
 * 自定义模板指令，定义完成后只需在engine中添加即可
 * @author may
 *
 */
public class Now extends Directive {

	@Override
	public void exec(Env env, Scope scope, Writer writer) {
		this.write(writer, new Date().toString());

	}

}
