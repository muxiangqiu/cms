package com.bstek.cms.web.serve.config;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.MemberConfig;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
public class MemberConfigController {
	
	@DataProvider
	@Transactional(readOnly = true)
	public void load(Page<MemberConfig> page) {
		JpaUtil
			.linq(MemberConfig.class)
			.asc("level")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<MemberConfig> memberConfigs) {
		JpaUtil.save(memberConfigs);
	}
	
}
