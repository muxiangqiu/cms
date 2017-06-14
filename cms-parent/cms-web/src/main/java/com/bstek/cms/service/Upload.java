package com.bstek.cms.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.FileInfo;
import com.bstek.dorado.uploader.DownloadFile;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileProvider;
import com.bstek.dorado.uploader.annotation.FileResolver;


@Controller("cms.upload")
@Transactional(readOnly = true)
public class Upload {
	
	@FileResolver
	@Transactional
	public FileInfo upload(UploadFile file, Map<String, Object> parameter) throws Exception {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setId(UUID.randomUUID().toString());
		fileInfo.setRelationId((String)parameter.get("relationId"));
		fileInfo.setRelationName((String)parameter.get("relationName"));
		fileInfo.setCreateDate(new Date());
		fileInfo.setSize(file.getSize()/1024);
		fileInfo.setName(file.getFileName());
		File dest = new File(FileUtils.getFileDirectory(), fileInfo.getId() + "@" + fileInfo.getName());
		fileInfo.setPath(dest.getAbsolutePath());	
		JpaUtil.persist(fileInfo);
		
		file.transferTo(dest);
		return fileInfo;
	}
	
	@FileProvider
	public DownloadFile download(Map<String, String> parameter) throws Exception {
		String fileId = parameter.get("fileId");
		FileInfo fileInfo = JpaUtil
				.linq(FileInfo.class)
				.equal("id", fileId)
				.findOne();
		return new DownloadFile(fileInfo.getName(), new FileInputStream(fileInfo.getPath()));
	}
}
