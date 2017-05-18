package com.bstek.cms.web.collect.website;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.WebsiteCollect;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class WebsiteCollectController {

	@DataProvider	
	public void load(Page<WebsiteCollect> page) {
		JpaUtil
			.linq(WebsiteCollect.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<WebsiteCollect> websites) {
		JpaUtil.save(websites);
	}
}
