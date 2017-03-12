package com.jfinal.test;

import com.jfinal.core.JFinal;

public class Test {

	public static void main(String[] args) {
		JFinal.start("JFinal_002_jetty_start\\WebContent", 8080, "/");
	}

}
