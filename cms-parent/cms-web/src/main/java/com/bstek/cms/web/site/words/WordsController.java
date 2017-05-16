package com.bstek.cms.web.site.words;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Words;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class WordsController {
	
	@DataProvider	
	public void load(Page<Words> page) {
		JpaUtil
			.linq(Words.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<Words> words) {
		JpaUtil.save(words);
	}
	
	@Expose
	public String validate(String name) {
		boolean result = JpaUtil.linq(Words.class).equal("name", name).exists();
		if (result) {
			return "该词汇已存在！";
		}
		return null;
	}
}
