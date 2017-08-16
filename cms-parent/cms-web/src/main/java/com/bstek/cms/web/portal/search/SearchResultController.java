package com.bstek.cms.web.portal.search;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
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
	
	@DataProvider	
	public List<Programa> loadTopPrograma() {
		return JpaUtil
			.linq(Programa.class)
			.isNull("parentId")
			.asc("order")
			.list();
	}
	
	@Expose
	public List<Document> loadDocumentsByPageNo(String value, int pageNo) {
		return JpaUtil
			.linq(Document.class)
			.like("name", "%" + value + "%")
			.desc("top")
			.desc("createDate")
			.list(pageNo-1, 10);
	}
	
	@Expose
	public int getPageNumber(String value) {
		int pageNumber, number, integerPart, remainder;
		Long count = JpaUtil.linq(Document.class).like("name", "%" + value + "%").count();
		number = count.intValue();
		
		if (number <= 10) {
			pageNumber = 1;
		} else {
			integerPart = number/10;
			remainder = number%10;
			if (remainder == 0) {
				pageNumber = integerPart;
			} else {
				pageNumber = integerPart + 1;
			}
		}
		return pageNumber;
	}

}
