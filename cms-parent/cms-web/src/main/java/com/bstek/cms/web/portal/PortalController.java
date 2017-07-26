package com.bstek.cms.web.portal;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class PortalController {
	
	@DataProvider
	public List<Programa> loadDocuments() {	
		Programa pro = JpaUtil.linq(Programa.class).equal("name", "首页").isNull("parentId").findOne();
		List<Programa> programas = JpaUtil.linq(Programa.class).equal("parentId", pro.getId()).asc("order").list();
		for (Programa programa : programas) {
			List<Document> documents = JpaUtil
				.linq(Document.class)
				.in(ProgramaDocumentLink.class)
					.select("documentId")
					.equal("programaId", programa.getId())
				.end()
				.desc("top")
				.desc("createDate")	
				.list(0, 10);
			programa.setDocuments(documents);
		}
		return programas;
	}
	
	@DataProvider
	public List<Document> loadAllDocuments(String value) {
		return JpaUtil
			.linq(Document.class)
			.like("name", "%" + value + "%")
			.desc("top")
			.desc("createDate")
			.list(0, 5);

	}


	@DataProvider
	public void loadDocumentByProgramaName(Page<Document> page, Criteria criteria, String programaName) {
		JpaUtil
			.linq(Document.class)
			.where(criteria)
			.equal("programaName", programaName)
			.desc("top")
			.desc("createDate")
			.paging(page);
	}
	
	@DataProvider	
	public List<Programa> loadTopPrograma() {
		return JpaUtil
			.linq(Programa.class)
			.isNull("parentId")
			.asc("order")
			.list();
	}
	
}
