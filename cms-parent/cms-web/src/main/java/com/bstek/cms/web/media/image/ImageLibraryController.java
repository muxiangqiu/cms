package com.bstek.cms.web.media.image;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import com.bstek.bdf3.dorado.jpa.JpaUtil;
import com.bstek.bdf3.dorado.jpa.policy.SaveContext;
import com.bstek.bdf3.dorado.jpa.policy.impl.SmartSavePolicyAdapter;
import com.bstek.cms.orm.FileInfo;
import com.bstek.cms.orm.LibraryFileLink;
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
		
		JpaUtil.save(mediaLibraries, new SmartSavePolicyAdapter() {

			@Override
			public void beforeInsert(SaveContext context) {
				if (context.getEntity() instanceof FileInfo) {
					FileInfo fileInfo = context.getEntity();
					MediaLibrary library = context.getParent();
					LibraryFileLink link = new LibraryFileLink();
					link.setId(UUID.randomUUID().toString());
					link.setLibraryId(library.getId());
					link.setFileId(fileInfo.getId());
					JpaUtil.persist(link);
				}
			}
			
			@Override
			public void beforeDelete(SaveContext context) {
				if (context.getEntity() instanceof FileInfo) {
					FileInfo fileInfo = context.getEntity();
					MediaLibrary library = context.getParent();
					JpaUtil.lind(LibraryFileLink.class)
						.equal("libraryId", library.getId())
						.equal("fileId", fileInfo.getId())
						.delete();					
				}
			}

		});
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
			.in(LibraryFileLink.class)
				.select("fileId")
				.equal("libraryId", libraryId)
			.end()
			.paging(page);
	}
}
