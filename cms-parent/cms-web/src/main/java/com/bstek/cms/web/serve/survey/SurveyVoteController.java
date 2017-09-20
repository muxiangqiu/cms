package com.bstek.cms.web.serve.survey;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.bdf3.dorado.jpa.policy.SaveContext;
import com.bstek.bdf3.dorado.jpa.policy.impl.SmartSavePolicyAdapter;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.cms.orm.Survey;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
public class SurveyVoteController {
	
	@DataProvider
	@Transactional(readOnly = true)
	public void loadSurveies(Page<Survey> page, String programaId) {
		JpaUtil
			.linq(Survey.class)
			.in(ProgramaDocumentLink.class)
				.select("surveyId")
				.equal("programaId", programaId)
			.end()
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<Programa> programas) {
		
		JpaUtil.save(programas, new SmartSavePolicyAdapter() {

			@Override
			public boolean beforeInsert(SaveContext context) {
				Survey survey = context.getEntity();
				Programa programa = context.getParent();
				ProgramaDocumentLink link = new ProgramaDocumentLink();
				link.setId(UUID.randomUUID().toString());
				link.setProgramaId(programa.getId());
				link.setSurveyId(survey.getId());
				JpaUtil.persist(link);
				return true;
			}
			
			@Override
			public boolean beforeDelete(SaveContext context) {
				Survey survey = context.getEntity();
				Programa programa = context.getParent();
				JpaUtil.lind(ProgramaDocumentLink.class)
					.equal("programaId", programa.getId())
					.equal("surveyId", survey.getId())
					.delete();
				return true;
			}

		});
	}
}
