package com.bstek.cms.orm;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bstek.bdf3.dorado.jpa.annotation.Generator;
import com.bstek.bdf3.dorado.jpa.policy.impl.CreatedDatePolicy;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * 媒体库 --文件信息
 *@author bob.yang
 *@since 2017年5月15日
 */
@Entity
@Table(name = "CMS_FILE_INFO")
public class FileInfo implements Serializable{

	private static final long serialVersionUID = -490719084338230389L;

	@Id	
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "主键")
	private String id;
		
	@Column(name = "NAME_", length = 512)
	@PropertyDef(label = "文件名称")
	private String name;
		
	@Column(name = "SIZE_")
	@PropertyDef(label = "文件大小")
	private long size;
		
	@Column(name = "PATH_", length = 512)
	@PropertyDef(label = "文件路径")
	private String path;
		
	@Column(name = "CATEGORY_", length = 100)
	@PropertyDef(label = "文件分类")
	private String category;
	
	@Column(name = "RELATION_NAME_", length = 100)
	@PropertyDef(label = "相关名称")
	private String relationName;
	
	@Column(name = "RELATION_ID_", length = 60)
	@PropertyDef(label = "相关ID")
	private String relationId;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "UPDATE_TIME_")
	@PropertyDef(label = "更新时间")
	private Date updateDate;
		
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	private String creator;
	
	@Column(name = "PARENT_NAME_", length = 60)
	@PropertyDef(label = "上级目录名称")
	private String parentName;
	
	@Column(name = "DESC_", length = 120)
	@PropertyDef(label = "描述")
	private String desc;

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

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}	

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
