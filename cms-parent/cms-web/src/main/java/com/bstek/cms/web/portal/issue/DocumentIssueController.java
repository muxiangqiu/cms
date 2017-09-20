package com.bstek.cms.web.portal.issue;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.bdf3.dorado.jpa.policy.SaveContext;
import com.bstek.bdf3.dorado.jpa.policy.impl.SmartSavePolicyAdapter;
import com.bstek.bdf3.security.ContextUtils;
import com.bstek.bdf3.security.orm.User;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;


@Controller
@Transactional(readOnly = true)
public class DocumentIssueController {
	
	@DataProvider
	public List<Programa> loadTopPrograma() {
		return JpaUtil
			.linq(Programa.class)
			.isNull("parentId")
			.asc("order")
			.list();
	}
	
	@DataProvider
	public List<Programa> loadSubPrograma(String parentId) {
		return JpaUtil
			.linq(Programa.class)
			.equal("parentId", parentId)
			.asc("order")
			.list();
	}
	
	@DataProvider
	public void loadDocumentsByStatus(Page<Document> page, String status) {
		User user = ContextUtils.getLoginUser();
		if (user != null) {
			JpaUtil
				.linq(Document.class)
				.addIf(status)
					.equal("status", status)
				.endIf()
				.equal("creator", user.getNickname())
				.desc("createDate")
				.paging(page);
		}
	}
	
	@DataResolver
	@Transactional
	public void save(List<Document> documents) {
		
		JpaUtil.save(documents, new SmartSavePolicyAdapter() {
			
			@Override
			public boolean beforeInsert(SaveContext context) {
				Document document = context.getEntity();
				String subProId = document.getSubProId();
				ProgramaDocumentLink link = new ProgramaDocumentLink();
				link.setId(UUID.randomUUID().toString());
				link.setProgramaId(subProId);
				link.setDocumentId(document.getId());
				JpaUtil.persist(link);
				return true;
			}
		});

	}


}
