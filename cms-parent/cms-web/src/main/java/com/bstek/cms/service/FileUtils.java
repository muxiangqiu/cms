package com.bstek.cms.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.bstek.dorado.core.Configure;
import com.bstek.dorado.web.DoradoContext;

public final class FileUtils {

	public static File getTempDirectory() {
		File tempDirectory = new File(System.getProperty("java.io.tmpdir"), "cms");
		if (!tempDirectory.exists() || !tempDirectory.isDirectory()) {
			tempDirectory.mkdirs();
		}
		return tempDirectory;
	}
	
	
	public static File getWebDirectory(String path){
		String realPath = DoradoContext.getAttachedServletContext().getRealPath("/");
		path = realPath + File.separator + path;
		File dir = new File(path);			
		return dir;

		
	}
	
	public static File getFileDirectory(){
		String prefix = Configure.getString("file.prefixPath");
		String suffix = new SimpleDateFormat("yyyy/MM/dd").format(new Date());		
		File dir;
		String realPath;
		if (StringUtils.isEmpty(prefix)) {
			realPath = DoradoContext.getAttachedServletContext().getRealPath("/");
			realPath += File.separator + "WEB-INF" + File.separator + "files" + File.separator +suffix;
		} else {
			if (StringUtils.endsWithIgnoreCase(prefix, "/")) {
				realPath = prefix + suffix;
			} else {
				realPath = prefix + File.separator + suffix;
			}
		}
		dir = new File(realPath);
		if(!dir.exists() || !dir.isDirectory()){
			dir.mkdirs();
		}
		return dir;
	}
	
}