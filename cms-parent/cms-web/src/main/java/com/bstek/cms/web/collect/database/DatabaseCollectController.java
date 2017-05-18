package com.bstek.cms.web.collect.database;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.DatabaseCollect;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class DatabaseCollectController {

	@DataProvider	
	public void load(Page<DatabaseCollect> page) {
		JpaUtil
			.linq(DatabaseCollect.class)
			.desc("createDate")
			.paging(page);
	}
	
	@DataResolver
	@Transactional
	public void save(List<DatabaseCollect> databaseCollects) {
		JpaUtil.save(databaseCollects);
	}
}
