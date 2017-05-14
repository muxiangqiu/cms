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
 *	评论
 * @author bob.yang
 * @since 2017年5月5日
 *
 */
@Entity
@Table(name = "CMS_REVIEW")
public class Review implements Serializable {

	private static final long serialVersionUID = -1958941544378326200L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "评论标题")
	private String name;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "评论人")
	private String observer;
	
	@Column(name = "PROGRAMAS_", length = 60)
	@PropertyDef(label = "所属栏目")
	private String programas;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "留言时间")
	private Date createDate;
	
	@Column(name = "CONTENT_", length = 240)
	@PropertyDef(label = "内容")
	private String content;
	
	@Column(name = "IP_", length = 60)
	@PropertyDef(label = "IP")
	private String ip;
	
	@Column(name = "STATUS_", length = 60)
	@PropertyDef(label = "审核状态")
	private boolean status;
	
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

	public String getObserver() {
		return observer;
	}

	public void setObserver(String observer) {
		this.observer = observer;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
