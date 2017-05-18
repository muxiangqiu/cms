package com.bstek.cms.web.collect.ftp;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.FTPCollect;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller("ftpCollectController")
@Transactional(readOnly = true)
public class FTPCollectController {

	@DataProvider	
	public void load(Page<FTPCollect> page) {
		JpaUtil
			.linq(FTPCollect.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<FTPCollect> ftps) {
		JpaUtil.save(ftps);
	}
}
