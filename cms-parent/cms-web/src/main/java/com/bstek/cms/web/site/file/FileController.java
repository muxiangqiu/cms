package com.bstek.cms.web.site.file;

import java.io.File;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.FileInfo;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
public class FileController {

	@DataProvider
	@Transactional(readOnly = true)
	public void load(Page<FileInfo> page) {
		JpaUtil
			.linq(FileInfo.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<FileInfo> files) {
		JpaUtil.save(files);
	}
	
	@DataResolver
	@Transactional
	public void delete(List<FileInfo> files) {
		JpaUtil.save(files);
		for (FileInfo fileInfo : files) {
			File file = new File(fileInfo.getPath());
			file.delete();
		}		
	}
}
