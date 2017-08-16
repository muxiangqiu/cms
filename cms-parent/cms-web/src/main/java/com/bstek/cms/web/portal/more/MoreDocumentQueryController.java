package com.bstek.cms.web.portal.more;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;


@Controller
@Transactional(readOnly = true)
public class MoreDocumentQueryController {
	
	@DataProvider
	public void loadDocumentsByProId(Page<Document> page, String proId) {	
		JpaUtil
			.linq(Document.class)
			.in(ProgramaDocumentLink.class)
				.select("documentId")
				.equal("programaId", proId)
			.end()
			.desc("top")
			.desc("createDate")	
			.paging(page);
	}
	
	@DataProvider
	public List<Programa> loadSubProgramas(String programaName) {
		Programa pro = JpaUtil.linq(Programa.class).equal("name", programaName).isNull("parentId").findOne();
		return JpaUtil
			.linq(Programa.class)
			.equal("parentId", pro.getId())
			.asc("order")
			.list();
	}

	@Expose
	public int loadCount(String topProName) {
		int count = 0;
		Programa topPro = JpaUtil.linq(Programa.class).equal("name", topProName).isNull("parentId").findOne();
		List<Programa> subPros = JpaUtil.linq(Programa.class).equal("parentId", topPro.getId()).list();
		for (Programa subPro : subPros) {
			Long subCount = JpaUtil
				.linq(Document.class)
				.in(ProgramaDocumentLink.class)
					.select("documentId")
					.equal("programaId", subPro.getId())
				.end()
				.count();
			int num = subCount.intValue();
			count += num;
		}
		return count;
	}

}
