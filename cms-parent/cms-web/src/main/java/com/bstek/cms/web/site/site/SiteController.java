package com.bstek.cms.web.site.site;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Site;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class SiteController {
	
	@DataProvider	
	public void load(Page<Site> page) {
		JpaUtil
			.linq(Site.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<Site> sites) {
		JpaUtil.save(sites);
	}
	
	@Expose
	public String validate(String name) {
		boolean result = JpaUtil.linq(Site.class).equal("name", name).exists();
		if (result) {
			return "该站点已存在！";
		}
		return null;
	}
}
