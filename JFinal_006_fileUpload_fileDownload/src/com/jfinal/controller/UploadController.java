package com.jfinal.controller;

import java.io.File;
import java.util.Calendar;

import com.jfinal.core.Controller;
import com.jfinal.kit.HandlerKit;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;

import sun.security.krb5.internal.tools.Kinit;

public class UploadController extends Controller {
	
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
