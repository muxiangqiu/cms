package com.bstek.cms.web.collect.dispense.catalog;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.DispenseCatalog;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class DispenseCatalogController {

	@DataProvider	
	public void load(Page<DispenseCatalog> page) {
		JpaUtil
			.linq(DispenseCatalog.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<DispenseCatalog> catalogs) {
		JpaUtil.save(catalogs);
	}
}
