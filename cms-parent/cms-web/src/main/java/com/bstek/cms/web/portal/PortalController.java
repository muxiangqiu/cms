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
		List<Programa> topPros = JpaUtil.linq(Programa.class).notEqual("name", "首页").isNull("parentId").asc("order").list();
			
		for (Programa topPro : topPros) {
			
			List<Programa> subPros = JpaUtil.linq(Programa.class).equal("parentId", topPro.getId()).asc("order").list();
			
			if (!subPros.isEmpty()) {
				List<Document> documents = JpaUtil
						.linq(Document.class)
						.in(ProgramaDocumentLink.class)
							.select("documentId")
							.equal("programaId", subPros.get(0).getId())
						.end()
						.desc("top")
						.desc("createDate")	
						.list(0, 10);
				topPro.setDocuments(documents);
			}	
		}
		return topPros;
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
	
	/*********************************************/
	
	@DataProvider
	public List<Document> loadDocumentsByTop(int number) {
		return JpaUtil
			.linq(Document.class)
			.desc("createDate")
			.list(number, 15);

	}
	
	@DataProvider
	public List<Programa> loadAssignTopPrograma() {
		return JpaUtil
				.linq(Programa.class)
				.isNull("parentId")
				.notEqual("name", "首页")
				.asc("order")
				.list(0, 6);
	}
	
	@DataProvider
	public List<Programa> loadSpecialColumnProgramas() throws Exception {
		List<Programa> topPros = JpaUtil.linq(Programa.class).equal("name", "首页").isNull("parentId").asc("order").list();
		if (!topPros.isEmpty()) {
			List<Programa> subPros = JpaUtil.linq(Programa.class).equal("parentId", topPros.get(0).getId()).asc("order").list();
			
			for (Programa subPro : subPros) {
				List<Document> documents = JpaUtil
						.linq(Document.class)
						.in(ProgramaDocumentLink.class)
							.select("documentId")
							.equal("programaId", subPro.getId())
						.end()
						.desc("top")
						.desc("createDate")	
						.list(0, 15);
				subPro.setDocuments(documents);
			}
			return subPros;
		}
		return null;
	}
	
}
