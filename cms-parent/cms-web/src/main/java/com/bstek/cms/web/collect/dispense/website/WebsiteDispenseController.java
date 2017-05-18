package com.bstek.cms.web.collect.dispense.website;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.WebsiteDispense;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class WebsiteDispenseController {

	@DataProvider	
	public void load(Page<WebsiteDispense> page) {
		JpaUtil
			.linq(WebsiteDispense.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<WebsiteDispense> websites) {
		JpaUtil.save(websites);
	}
}
