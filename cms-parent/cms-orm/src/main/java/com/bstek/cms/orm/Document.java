package com.bstek.cms.orm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bstek.bdf3.dorado.jpa.annotation.Generator;
import com.bstek.bdf3.dorado.jpa.policy.impl.CreatedDatePolicy;
import com.bstek.bdf3.dorado.jpa.policy.impl.UpdatedDatePolicy;
import com.bstek.dorado.annotation.PropertyDef;

/**
 *	文档
 * @author bob.yang
 * @since 2017年5月2日
 *
 */
@Entity
@Table(name = "CMS_DOCUMENT")
public class Document implements Serializable {

	private static final long serialVersionUID = 5200616666336968316L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "标题")
	private String name;
	
	@Column(name = "PROGRAMA_NAME_", length = 60)
	@PropertyDef(label = "所属栏目名称")
	private String programaName;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	private String creator;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "UPDATE_TIME_")
	@Generator(policy = UpdatedDatePolicy.class)
	@PropertyDef(label = "修改时间")
	private Date updateDate;
	
	@Column(name = "START_DATE_")
	@PropertyDef(label = "有效期")
	private Date startDate;
	
	@Column(name = "END_DATE_")
	@PropertyDef(label = "至")
	private Date endDate;
	
	@Column(name = "CONTENT_")
	@PropertyDef(label = "内容")
	@Lob
	private String content;
	
	@Column(name = "TYPE_", length = 60)
	@PropertyDef(label = "类型")
	private String type;
	
	@Column(name = "DEPT_ID_", length = 60)
	@PropertyDef(label = "部门")
	private String deptId;
	
	@Column(name = "TOP_")
	@PropertyDef(label = "置顶")
	private boolean top;
	
	@Column(name = "DOCUMENT_STATUS_")
	@PropertyDef(label = "状态")
	private DocumentStatus status;
	
	@Column(name = "SECURITY_LEVEL_")
	@PropertyDef(label = "密级")
	private SecurityLevelType securityLevel;
	
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

	public String getProgramaName() {
		return programaName;
	}

	public void setProgramaName(String programaName) {
		this.programaName = programaName;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public DocumentStatus getStatus() {
		return status;
	}

	public void setStatus(DocumentStatus status) {
		this.status = status;
	}

	public SecurityLevelType getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevelType securityLevel) {
		this.securityLevel = securityLevel;
	}

	public List<Programa> getPros() {
		return pros;
	}

	public void setPros(List<Programa> pros) {
		this.pros = pros;
	}

}
