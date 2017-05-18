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
 *	采集与分发-- 分发到目录
 * @author bob.yang
 * @since 2017年5月15日
 *
 */
@Entity
@Table(name = "CMS_DISPENSE_CATALOG")
public class DispenseCatalog implements Serializable {

	private static final long serialVersionUID = -6409814241009984972L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "复制方式")
	private String copy;
	
	@Column(name = "LOCAL_CATALOG_", length = 60)
	@PropertyDef(label = "本地目录")
	private String localCatalog;
	
	@Column(name = "LOCAL_File_", length = 60)
	@PropertyDef(label = "本地文件")
	private String localFile;
		
	@Column(name = "TARGET_CATALOG_", length = 60)
	@PropertyDef(label = "目标目录")
	private String targetCatalog;
	
	@Column(name = "TARGET_File_", length = 60)
	@PropertyDef(label = "目标文件")
	private String targetFile;
	
	@Column(name = "URL_", length = 60)
	@PropertyDef(label = "服务器地址")
	private String url;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	private String creator;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "STATUS_", length = 60)
	@PropertyDef(label = "启用状态")
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCopy() {
		return copy;
	}

	public void setCopy(String copy) {
		this.copy = copy;
	}

	public String getLocalCatalog() {
		return localCatalog;
	}

	public void setLocalCatalog(String localCatalog) {
		this.localCatalog = localCatalog;
	}

	public String getLocalFile() {
		return localFile;
	}

	public void setLocalFile(String localFile) {
		this.localFile = localFile;
	}

	public String getTargetCatalog() {
		return targetCatalog;
	}

	public void setTargetCatalog(String targetCatalog) {
		this.targetCatalog = targetCatalog;
	}

	public String getTargetFile() {
		return targetFile;
	}

	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
	
}
