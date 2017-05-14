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
 *	文档审核
 * @author bob.yang
 * @since 2017年5月2日
 *
 */
@Entity
@Table(name = "CMS_AUDIT")
public class Audit implements Serializable {

	private static final long serialVersionUID = 7245166764199055275L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "标题")
	private String name;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	private String creator;
	
	@Column(name = "HANDLER_", length = 60)
	@PropertyDef(label = "处理人")
	private String handler;
	
	@Column(name = "PROGRAMAS_", length = 60)
	@PropertyDef(label = "所属栏目")
	private String programas;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "DOCUMENT_STATUS_")
	@PropertyDef(label = "状态")
	private DocumentStatus status;
	
	@Column(name = "LAST_ACTION_", length = 120)
	@PropertyDef(label = "上次动作")
	private String lastAction;
	
	@Column(name = "CURRENT_STEP_", length = 120)
	@PropertyDef(label = "当前步骤")
	private String currentStep;
	
	@Column(name = "MARK_", length = 60)
	@PropertyDef(label = "标志")
	private String mark;
	
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

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
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

	public DocumentStatus getStatus() {
		return status;
	}

	public void setStatus(DocumentStatus status) {
		this.status = status;
	}

	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	public String getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(String currentStep) {
		this.currentStep = currentStep;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public List<Programa> getPros() {
		return pros;
	}

	public void setPros(List<Programa> pros) {
		this.pros = pros;
	}
	
}
