package com.bstek.cms.web.portal;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;

@Controller
public class PortalController {
	
	@DataProvider
	@Transactional(readOnly = true)
	public List<Programa> loadDocuments() {	
		List<Programa> programas = JpaUtil.linq(Programa.class).asc("order").list();
		for (Programa programa : programas) {
			List<Document> documents = JpaUtil
				.linq(Document.class)
				.in(ProgramaDocumentLink.class)
					.select("documentId")
					.equal("programaId", programa.getId())
				.end()
				.desc("top")
				.desc("createDate")	
				.list(0, 7);
			programa.setDocuments(documents);
		}
		return programas;
	}
	
	@DataProvider
	@Transactional(readOnly = true)
	public List<Document> loadDocumentByName(String name) {
		return JpaUtil
			.linq(Document.class)
			.equal("name", name)
			.list();
	}
}
