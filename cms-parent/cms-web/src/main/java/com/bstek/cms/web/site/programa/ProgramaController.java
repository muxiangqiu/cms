package com.bstek.cms.web.site.programa;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Programa;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;

@Controller
@Transactional(readOnly = true)
public class ProgramaController {
	
	@DataProvider
	public List<Programa> load(String parentId) {
		return JpaUtil
			.linq(Programa.class)
			.addIfNot(parentId)
				.isNull("parentId")
			.endIf()
			.addIf(parentId)
				.equal("parentId", parentId)
			.endIf()
			.asc("order")
			.list();
	}
	
	@DataProvider
	public List<Programa> loadAll() {
		return JpaUtil
				.linq(Programa.class)
				.isNotNull("parentId")
				.asc("createTime")
				.asc("order")
				.list();
	}
	
	@DataResolver
	@Transactional
	public void save(List<Programa> programs) {
		JpaUtil.save(programs);
	}
	
	@Expose
	public String validate(String name) {
		boolean result = JpaUtil.linq(Programa.class).isNull("parentId").equal("name", name).exists();
		if (result) {
			return "该栏目名称已存在！";
		}
		return null;
	}
}
