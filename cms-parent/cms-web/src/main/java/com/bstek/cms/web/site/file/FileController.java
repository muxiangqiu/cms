package com.bstek.cms.web.site.file;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.File;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
public class FileController {

	@DataProvider
	@Transactional(readOnly = true)
	public void load(Page<File> page) {
		JpaUtil
			.linq(File.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<File> files) {
		JpaUtil.save(files);
	}
}
