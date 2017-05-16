package com.bstek.cms.web.site.template;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Template;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
public class TemplateController {
	
	@DataProvider
	@Transactional(readOnly = true)
	public void load(Page<Template> page) {
		JpaUtil
			.linq(Template.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<Template> templates) {
		JpaUtil.save(templates);
	}
}
