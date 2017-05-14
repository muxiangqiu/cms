package com.bstek.cms.web.serve.retrieve;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Retrieve;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class RetrieveController {
	
	@DataProvider	
	public void load(Page<Retrieve> page) {
		JpaUtil
			.linq(Retrieve.class)
			.asc("code")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<Retrieve> retrieves) {
		JpaUtil.save(retrieves);
	}
	
	@Expose	
	public String validate(String code) {
		boolean result = JpaUtil.linq(Retrieve.class).equal("code", code).exists();
		if (result) {
			return "该代码已存在！";
		}
		return null;
	}
}
