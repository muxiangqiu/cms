package com.bstek.cms.web.portal.preview;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;

@Controller
@Transactional(readOnly = true)
public class DocumentQueryController {

	@DataProvider
	public List<Programa> loadHotNews(String programaName) {	
		Programa pro = JpaUtil.linq(Programa.class).equal("name", programaName).isNull("parentId").findOne();
		List<Programa> programas = JpaUtil.linq(Programa.class).equal("parentId", pro.getId()).like("name", "%热点").list();	
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
	public List<Programa> loadDocumentsOther(String programaName) {	
		Programa pro = JpaUtil.linq(Programa.class).equal("name", programaName).isNull("parentId").findOne();
		List<Programa> programas = JpaUtil.linq(Programa.class).equal("parentId", pro.getId()).notLike("name", "%热点").asc("createTime").list();
		for (Programa programa : programas) {
			List<Document> documents = JpaUtil
					.linq(Document.class)
					.in(ProgramaDocumentLink.class)
						.select("documentId")
						.equal("programaId", programa.getId())
					.end()
					.desc("top")
					.desc("createDate")	
					.list(0, 6);
			programa.setDocuments(documents);
		}		
		return programas;
	}
}
