package com.bstek.cms.orm;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bstek.bdf3.dorado.jpa.annotation.Generator;
import com.bstek.bdf3.dorado.jpa.policy.impl.CreatedDatePolicy;
import com.bstek.dorado.annotation.PropertyDef;

/**
 *	会员
 * @author bob.yang
 * @since 2017年5月5日
 *
 */
@Entity
@Table(name = "CMS_MEMBER")
public class Member implements Serializable {

	private static final long serialVersionUID = 284373183908710403L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "MEMBER_CONFIG_ID_", length = 60)
	@PropertyDef(label = "会员配置ID")
	private String memberConfigId;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "姓名")
	private String name;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	private String creator;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "USERNAME_", length = 60)
	@PropertyDef(label = "登录名")
	private String username;
	
	@Column(name = "PASSWORD_", length = 60)
	@PropertyDef(label = "密码")
	private String password;
	
	@Column(name = "EMAIL_", length = 60)
	@PropertyDef(label = "电子邮箱")
	private String email;
	
	@Column(name = "TYPE_", length = 60)
	@PropertyDef(label = "会员类型")
	private String type;	
	
	@Column(name = "SEX_")
	@PropertyDef(label = "性别")
	private String sex;
	
	@Column(name = "CREDITS_", length = 60)
	@PropertyDef(label = "积分")
	private Integer credits;
	
	@Column(name = "ADDRESS_", length = 60)
	@PropertyDef(label = "地址管理")
	private String address;
	
	@Column(name = "AUDIT_")
	@PropertyDef(label = "审核状态")
	private String audit;
	
	@Column(name = "QUESTION_", length = 60)
	@PropertyDef(label = "密码问题")
	private String question;
	
	@Column(name = "ANSWER_", length = 60)
	@PropertyDef(label = "密码回答")
	private String answer;
	
	@Transient
	private MemberConfig level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberConfigId() {
		return memberConfigId;
	}

	public void setMemberConfigId(String memberConfigId) {
		this.memberConfigId = memberConfigId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAudit() {
		return audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public MemberConfig getLevel() {
		return level;
	}

	public void setLevel(MemberConfig level) {
		this.level = level;
	}


}
