package com.jfinal.controller;

import java.io.File;
import java.util.Calendar;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.intercept.ClassIntercept;
import com.jfinal.intercept.InjectInterceptor;
import com.jfinal.intercept.MethodIntercept;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.service.UserService;
import com.jfinal.upload.UploadFile;

@Before({ClassIntercept.class})
public class UploadController extends Controller {
	
	@Clear//清除method级别以上的所有拦截器，也可指定清除哪些，清除后这些拦截器对当前的方法将不会进行拦截
	//@Before({MethodIntercept.class, Tx.class})//Tx是jfinal自带的事物拦截器
	@Before(MethodIntercept.class)
	public void login() {
		UserService service = enhance(UserService.class, InjectInterceptor.class);//增强UserService将aop功能设置到业务层
		//UserService service = new UserService();
		service.login();
		renderNull();
		
	}
	
	public void index() {
		
		
		
		renderFreeMarker("/WEB-INF/upload/upload.html");
	}
	
	public void upload() {
		
		
		//在上传路径下创建一个跟时间对应的目录，将文件放到这个文件下。
		UploadFile uploadFile = this.getFile("file", Calendar.getInstance().getTimeInMillis()+"");
		
		
		
		renderText(uploadFile.getUploadPath());
		
	}
	
	public void download() {
		
		//PathKit.getWebRootPath()
	//	HttpKit.
		//com.jfinal.kit这个包里有许多的辅助类
		//HandlerKit.renderError404(request, response, isHandled);
	//	this.getRequest()
	//this.setSessionAttr(key, value)
		File file = new File("D:/javaworkspace_2017_3_5/JFinal_006_fileUpload_fileDownload/src/ehcache.xml");
		System.out.println(file.isFile());
		renderFile(file);
		//render(render);//这种方式依靠config中设置的视图类型来解析
		
	}

}
