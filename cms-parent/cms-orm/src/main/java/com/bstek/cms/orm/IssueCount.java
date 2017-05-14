package com.bstek.cms.orm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.bstek.dorado.annotation.PropertyDef;

/**
 *	发布统计
 * @author bob.yang
 * @since 2017年5月5日
 *
 */
@Entity
@Table(name = "CMS_ISSUE_COUNT")
public class IssueCount implements Serializable {

	private static final long serialVersionUID = 5347354628989472523L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "USERNAME_", length = 60)
	@PropertyDef(label = "录入用户")
	private String username;
	
	@Column(name = "PROGRAMA_NAME_", length = 60)
	@PropertyDef(label = "栏目名称")
	private String programaName;
	
	@Column(name = "DRAFT_COUNT_", length = 60)
	@PropertyDef(label = "初稿数")
	private Integer draftCount;
	
	@Column(name = "RUTEN_COUNT_", length = 60)
	@PropertyDef(label = "流转数")
	private Integer rutenCount;
	
	@Column(name = "ISSUE_COUNT_", length = 60)
	@PropertyDef(label = "已发布数")
	private Integer issueCount;
	
	@Column(name = "DATED_COUNT_", length = 60)
	@PropertyDef(label = "已下线数")
	private Integer datedCount;
	
	@Column(name = "ARCHIVE_COUNT_", length = 60)
	@PropertyDef(label = "已归档数")
	private Integer archiveCount;
	
	@Column(name = "SUM_", length = 60)
	@PropertyDef(label = "文章总数")
	private Integer sum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProgramaName() {
		return programaName;
	}

	public void setProgramaName(String programaName) {
		this.programaName = programaName;
	}

	public Integer getDraftCount() {
		return draftCount;
	}

	public void setDraftCount(Integer draftCount) {
		this.draftCount = draftCount;
	}

	public Integer getRutenCount() {
		return rutenCount;
	}

	public void setRutenCount(Integer rutenCount) {
		this.rutenCount = rutenCount;
	}

	public Integer getIssueCount() {
		return issueCount;
	}

	public void setIssueCount(Integer issueCount) {
		this.issueCount = issueCount;
	}

	public Integer getDatedCount() {
		return datedCount;
	}

	public void setDatedCount(Integer datedCount) {
		this.datedCount = datedCount;
	}

	public Integer getArchiveCount() {
		return archiveCount;
	}

	public void setArchiveCount(Integer archiveCount) {
		this.archiveCount = archiveCount;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	
}
