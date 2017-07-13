package com.bstek.cms.orm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bstek.bdf3.dorado.jpa.annotation.Generator;
import com.bstek.bdf3.dorado.jpa.policy.impl.CreatedDatePolicy;
import com.bstek.cms.policy.CreatorPolicy;
import com.bstek.dorado.annotation.PropertyDef;


/**
 *	 媒体库
 * @author bob.yang
 * @since 2017年5月15日
 *
 */
@Entity
@Table(name = "CMS_MEDIA_LIBRARY")
public class MediaLibrary implements Serializable {

	private static final long serialVersionUID = 2542384746446761969L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "库名称")
	private String name;
	
	@Column(name = "PARENT_ID_", length = 60)
	@PropertyDef(label = "上级ID")
	private String parentId;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	@Generator(policy = CreatorPolicy.class)
	private String creator;
	
	@Column(name = "CREATE_TIME_", length = 60)
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createTime;
	
	@Column(name = "TYPE_")
	@PropertyDef(label = "库类型")
	private MediaLibraryType type;
	
	@Column(name = "DESC_", length = 120)
	@PropertyDef(label = "描述")
	private String desc;
	
	@Transient
	private List<MediaLibrary> children;
	
	@Transient
	private List<FileInfo> fileInfos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	public MediaLibraryType getType() {
		return type;
	}

	public void setType(MediaLibraryType type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<MediaLibrary> getChildren() {
		return children;
	}

	public void setChildren(List<MediaLibrary> children) {
		this.children = children;
	}

	public List<FileInfo> getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(List<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}

	

}
