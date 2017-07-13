package com.bstek.cms.orm;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.bstek.bdf3.dorado.jpa.annotation.Generator;
import com.bstek.bdf3.dorado.jpa.policy.impl.CreatedDatePolicy;
import com.bstek.cms.policy.CreatorPolicy;
import com.bstek.dorado.annotation.PropertyDef;

/**
 *	 媒体库-文件 关系表
 * @author bob.yang
 * @since 2017年5月15日
 *
 */
@Entity
@Table(name = "CMS_LIBRARY_FILE_LINK")
public class LibraryFileLink implements Serializable {

	private static final long serialVersionUID = 2597183900604955459L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "LIBRARY_ID_", length = 60)
	@PropertyDef(label = "媒体库ID")
	private String libraryId;
	
	@Column(name = "FILE_ID_", length = 60)
	@PropertyDef(label = "文件ID")
	private String fileId;
		
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	@Generator(policy = CreatorPolicy.class)
	private String creator;
	
	@Column(name = "CREATE_TIME_", length = 60)
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
