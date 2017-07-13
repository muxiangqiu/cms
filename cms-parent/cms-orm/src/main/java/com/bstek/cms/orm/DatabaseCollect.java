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
 *	采集与分发-- 数据库采集
 * @author bob.yang
 * @since 2017年5月15日
 *
 */
@Entity
@Table(name = "CMS_DATABASE_COLLECT")
public class DatabaseCollect implements Serializable {

	private static final long serialVersionUID = -2413786615870742248L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "任务名称")
	private String name;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	@Generator(policy = CreatorPolicy.class)
	private String creator;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "STATUS_", length = 60)
	@PropertyDef(label = "任务状态")
	private String status;
	
	@Column(name = "TARGET_PROGRAMA_", length = 60)
	@PropertyDef(label = "采集到此栏目")
	private String targetPrograma;
	
	@Column(name = "LINK_NAME_", length = 60)
	@PropertyDef(label = "外部连接名称")
	private String linkName;
	
	@Column(name = "TABLE_NAME_", length = 60)
	@PropertyDef(label = "表名称")
	private String tableName;

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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTargetPrograma() {
		return targetPrograma;
	}

	public void setTargetPrograma(String targetPrograma) {
		this.targetPrograma = targetPrograma;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
}
