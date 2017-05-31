package com.bstek.cms.web.document.edit;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.bdf3.dorado.jpa.policy.SaveContext;
import com.bstek.bdf3.dorado.jpa.policy.impl.SmartSavePolicyAdapter;
import com.bstek.cms.orm.Document;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;

@Controller
public class DocumentEditController {
	
	@DataProvider
	@Transactional(readOnly = true)
	public void loadDocuments(Page<Document> page, String programaId) {
	
		JpaUtil
			.linq(Document.class)
			.in(ProgramaDocumentLink.class)
				.select("documentId")
				.equal("programaId", programaId)
			.end()
			.asc("order")
			.desc("createDate")			
			.paging(page);	
	}
	
	
	@DataResolver
	@Transactional
	public void save(List<Programa> programas) {
		
		JpaUtil.save(programas, new SmartSavePolicyAdapter() {

			@Override
			public void beforeInsert(SaveContext context) {
				Document document = context.getEntity();
				Programa programa = context.getParent();
				ProgramaDocumentLink link = new ProgramaDocumentLink();
				link.setId(UUID.randomUUID().toString());
				link.setProgramaId(programa.getId());
				link.setDocumentId(document.getId());
				JpaUtil.persist(link);
			}
			
			@Override
			public void beforeDelete(SaveContext context) {
				Document document = context.getEntity();
				Programa programa = context.getParent();
				JpaUtil.lind(ProgramaDocumentLink.class)
					.equal("programaId", programa.getId())
					.equal("documentId", document.getId())
					.delete();
			}

		});
	}
	
	@Expose
	@Transactional
	public void copyOrMove(List<Programa> programas, List<Document> documents, Programa currentPrograma, boolean move) {
		if (move) {
			for (Programa programa : programas) {
				for (Document document : documents) {
					ProgramaDocumentLink link = new ProgramaDocumentLink();
					link.setId(UUID.randomUUID().toString());
					link.setProgramaId(programa.getId());
					link.setDocumentId(document.getId());
					JpaUtil.persist(link);
					JpaUtil.lind(ProgramaDocumentLink.class)
						.equal("programaId", currentPrograma.getId())
						.equal("documentId", document.getId())
						.delete();
				}
			}
		} else {
			for (Programa programa : programas) {
				for (Document document : documents) {
					ProgramaDocumentLink link = new ProgramaDocumentLink();
					link.setId(UUID.randomUUID().toString());
					link.setProgramaId(programa.getId());
					link.setDocumentId(document.getId());
					JpaUtil.persist(link);
				}
			}
		}		
	}
}
