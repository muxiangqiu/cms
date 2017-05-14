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
import com.bstek.dorado.annotation.PropertyDef;


/**
 *	 栏目
 * @author bob.yang
 * @since 2017年5月2日
 *
 */
@Entity
@Table(name = "CMS_PROGRAMA")
public class Programa implements Serializable {

	private static final long serialVersionUID = 2999193771289213821L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "栏目名称")
	private String name;
	
	@Column(name = "PARENT_ID_", length = 60)
	@PropertyDef(label = "上级ID")
	private String parentId;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")

	private String creator;
	
	@Column(name = "CREATE_TIME_", length = 60)
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createTime;
	
	@Column(name = "ORDER_", length = 60)
	@PropertyDef(label = "序号")
	private Integer order;
	
	@Column(name = "DESC_", length = 120)
	@PropertyDef(label = "描述")
	private String desc;
	
	@Transient
	private List<Programa> children;
	
	@Transient
	private List<Document> documents;

	@Transient
	private List<Survey> surveies;
	
	@Transient
	private List<Advertisement> advertisements;
	
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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Programa> getChildren() {
		return children;
	}

	public void setChildren(List<Programa> children) {
		this.children = children;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<Survey> getSurveies() {
		return surveies;
	}

	public void setSurveies(List<Survey> surveies) {
		this.surveies = surveies;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	
}
