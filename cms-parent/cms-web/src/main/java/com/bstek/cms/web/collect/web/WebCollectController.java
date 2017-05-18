package com.bstek.cms.web.collect.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.WebCollect;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class WebCollectController {
	
	@DataProvider	
	public void load(Page<WebCollect> page) {
		JpaUtil
			.linq(WebCollect.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<WebCollect> webs) {
		JpaUtil.save(webs);
	}
}
