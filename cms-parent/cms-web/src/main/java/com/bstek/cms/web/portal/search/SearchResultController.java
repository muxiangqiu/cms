package com.bstek.cms.web.portal.search;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class SearchResultController {

	@DataProvider
	public void loadDocumentsByEditorValue(Page<Document> page, String editorValue) {
		JpaUtil
			.linq(Document.class)
			.like("name", "%" + editorValue + "%")
			.desc("top")
			.desc("createDate")
			.paging(page);
	}
}
