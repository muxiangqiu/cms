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
 *	调查和投票
 * @author bob.yang
 * @since 2017年5月2日
 *
 */
@Entity
@Table(name = "CMS_SURVEY")
public class Survey implements Serializable {

	private static final long serialVersionUID = 7031624592793311260L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "调查主题")
	private String name;
	
	@Column(name = "VOTEUSER_", length = 60)
	@PropertyDef(label = "投票人数")
	private Integer voteuser;
	
	@Column(name = "ASTRICT_IP_", length = 60)
	@PropertyDef(label = "限制IP")
	private String astrictIP;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	private String creator;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "START_TIME_")
	@PropertyDef(label = "开始时间")
	private Date startTime;
	
	@Column(name = "END_TIME_")
	@PropertyDef(label = "截至时间")
	private Date endTime;
	
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

	public Integer getVoteuser() {
		return voteuser;
	}

	public void setVoteuser(Integer voteuser) {
		this.voteuser = voteuser;
	}

	public String getAstrictIP() {
		return astrictIP;
	}

	public void setAstrictIP(String astrictIP) {
		this.astrictIP = astrictIP;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<Programa> getPros() {
		return pros;
	}

	public void setPros(List<Programa> pros) {
		this.pros = pros;
	}

}
