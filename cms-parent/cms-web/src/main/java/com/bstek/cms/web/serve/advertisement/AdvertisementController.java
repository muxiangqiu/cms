package com.bstek.cms.web.serve.advertisement;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.bdf3.dorado.jpa.policy.SaveContext;
import com.bstek.bdf3.dorado.jpa.policy.impl.SmartSavePolicyAdapter;
import com.bstek.cms.orm.Advertisement;
import com.bstek.cms.orm.Programa;
import com.bstek.cms.orm.ProgramaDocumentLink;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
public class AdvertisementController {

	@DataProvider
	@Transactional(readOnly = true)
	public void loadAdvertisements(Page<Advertisement> page, String programaId) {
		JpaUtil
			.linq(Advertisement.class)
			.in(ProgramaDocumentLink.class)
				.select("advertisementId")
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
			public void beforeInsert(SaveContext context) {
				Advertisement advertisement = context.getEntity();
				Programa programa = context.getParent();
				ProgramaDocumentLink link = new ProgramaDocumentLink();
				link.setId(UUID.randomUUID().toString());
				link.setProgramaId(programa.getId());
				link.setAdvertisementId(advertisement.getId());
				JpaUtil.persist(link);
			}
			
			@Override
			public void beforeDelete(SaveContext context) {
				Advertisement advertisement = context.getEntity();
				Programa programa = context.getParent();
				JpaUtil.lind(ProgramaDocumentLink.class)
					.equal("programaId", programa.getId())
					.equal("advertisementId", advertisement.getId())
					.delete();
			}

		});
	}
}
