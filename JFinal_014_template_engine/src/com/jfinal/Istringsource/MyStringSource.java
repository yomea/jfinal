package com.jfinal.Istringsource;

import com.jfinal.template.IStringSource;

public class MyStringSource implements IStringSource {

	@Override
	public String getKey() {
		
		return "test";
	}

	/**
	 * 可以写些自己的逻辑，比如从socket中传过来的数据
	 */
	@Override
	public StringBuilder getContent() {
		
		return new StringBuilder("#(x+1)");
	}

	@Override
	public String getEncoding() {
		
		return "utf-8";
	}

}
