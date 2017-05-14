package com.bstek.cms.web.serve.member;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Member;
import com.bstek.cms.orm.MemberConfig;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class MemberController {
	
	@DataProvider
	public void load(Page<Member> page) {
		JpaUtil
			.linq(Member.class)
			.collect(MemberConfig.class, "memberConfigId")
			.asc("username")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<Member> members) {
		JpaUtil.save(members);
	}
	
	@Expose
	public String validate(String username) {
		boolean result = JpaUtil.linq(Member.class).equal("username", username).exists();
		if (result) {
			return "该登录名已存在！";
		}
		return null;
	}
}
