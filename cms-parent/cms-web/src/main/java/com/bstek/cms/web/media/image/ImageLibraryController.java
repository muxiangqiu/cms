package com.bstek.cms.web.media.image;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.cms.orm.FileInfo;
import com.bstek.cms.orm.MediaLibrary;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;

@Controller
@Transactional(readOnly = true)
public class ImageLibraryController {

	@DataProvider
	public List<MediaLibrary> load(String parentId) {
		return JpaUtil
			.linq(MediaLibrary.class)
			.addIfNot(parentId)
				.isNull("parentId")
				.equal("type", 0)
			.endIf()
			.addIf(parentId)
				.equal("parentId", parentId)
			.endIf()			
			.list();
	}
	
	@DataResolver
	@Transactional
	public void save(List<MediaLibrary> mediaLibraries) {	
		JpaUtil.save(mediaLibraries);
	}
	
	@Expose
	public String validate(String name) {
		boolean result = JpaUtil.linq(MediaLibrary.class).equal("name", name).exists();
		if (result) {
			return "该分类已存在！";
		}
		return null;
	}
	
	@DataProvider
	public void loadImageByLibraryId(Page<FileInfo> page, String libraryId) {
		JpaUtil
			.linq(FileInfo.class)
			.equal("relationId", libraryId)
			.paging(page);
	}
}
