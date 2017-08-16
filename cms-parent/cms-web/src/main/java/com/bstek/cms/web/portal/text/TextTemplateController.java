package com.bstek.cms.web.portal.text;


import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;

@Controller
@Transactional(readOnly = true)
public class TextTemplateController {

	@DataProvider
	public List<Document> loadDocumentByName(String name) {
		return JpaUtil
			.linq(Document.class)
			.equal("name", name)
			.list();

	}
	

	@DataProvider	
	public List<Programa> loadTopPrograma() {
		return JpaUtil
			.linq(Programa.class)
			.isNull("parentId")
			.asc("order")
			.list();
	}
	
	@Expose
	@Transactional
	public void saveBrowseNumber(String docId, Integer browseNumber) {
		JpaUtil
			.linu(Document.class)
			.equal("id", docId)
			.set("browseNumber", browseNumber)
			.update();
	}

}
