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
 *	广告
 * @author bob.yang
 * @since 2017年5月5日
 *
 */
@Entity
@Table(name = "CMS_ADVERTISEMENT")
public class Advertisement implements Serializable {

	private static final long serialVersionUID = -7065378670447528995L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "版位名称")
	private String name;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	@Generator(policy = CreatorPolicy.class)
	private String creator;
	
	@Column(name = "PROGRAMAS_", length = 60)
	@PropertyDef(label = "所属栏目")
	private String programas;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "AD_TYPE_", length = 60)
	@PropertyDef(label = "广告类型")
	private String adType;
	
	@Column(name = "POSITION_TYPE_", length = 60)
	@PropertyDef(label = "版位类型")
	private String PositionType;
		
	@Column(name = "JS_URL_", length = 120)
	@PropertyDef(label = "JS路径")
	private String jsUrl;
	
	@Column(name = "SIZE_", length = 60)
	@PropertyDef(label = "尺寸")
	private String size;
	
	@Column(name = "DESC_", length = 120)
	@PropertyDef(label = "版位描述")
	private String desc;
	
	@Transient
	private List<Programa> pros;
	
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

	public String getProgramas() {
		return programas;
	}

	public void setProgramas(String programas) {
		this.programas = programas;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getPositionType() {
		return PositionType;
	}

	public void setPositionType(String positionType) {
		PositionType = positionType;
	}

	public String getJsUrl() {
		return jsUrl;
	}

	public void setJsUrl(String jsUrl) {
		this.jsUrl = jsUrl;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Programa> getPros() {
		return pros;
	}

	public void setPros(List<Programa> pros) {
		this.pros = pros;
	}
	
	
}
