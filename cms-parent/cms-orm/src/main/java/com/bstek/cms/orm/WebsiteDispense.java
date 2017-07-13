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
 *	采集与分发-- 网站群分发
 * @author bob.yang
 * @since 2017年5月15日
 *
 */
@Entity
@Table(name = "CMS_WEBSITE_DISPENSE")
public class WebsiteDispense implements Serializable {

	private static final long serialVersionUID = -3928857744451514412L;

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
	
	@Column(name = "TYPE_", length = 60)
	@PropertyDef(label = "分发类型")
	private String type;
	
	@Column(name = "CURRENT_PROGRAMA_", length = 60)
	@PropertyDef(label = "从此栏目开始分发")
	private String currentPrograma;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrentPrograma() {
		return currentPrograma;
	}

	public void setCurrentPrograma(String currentPrograma) {
		this.currentPrograma = currentPrograma;
	}
	
	
}
