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
 *	站点
 * @author bob.yang
 * @since 2017年5月12日
 *
 */
@Entity
@Table(name = "CMS_SITE")
public class Site implements Serializable {

	private static final long serialVersionUID = -2702210665460659181L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "站点名称")
	private String name;
	
	@Column(name = "CODE_", length = 60)
	@PropertyDef(label = "站点代码")
	private String code;
	
	@Column(name = "DOMAIN_NAME_", length = 60)
	@PropertyDef(label = "域名")
	private String domainName;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	@Generator(policy = CreatorPolicy.class)
	private String creator;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "UPDATE_TIME_")
	@PropertyDef(label = "更新时间")
	private Date updateDate;
	
	@Column(name = "DESC_", length = 60)
	@PropertyDef(label = "站点描述")
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
