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
 *	采集与分发-- FTP采集
 * @author bob.yang
 * @since 2017年5月15日
 *
 */
@Entity
@Table(name = "CMS_FTP_COLLECT")
public class FTPCollect implements Serializable {

	private static final long serialVersionUID = -2910940698687530583L;

	@Id
	@Column(name = "ID_", length = 60)
	@PropertyDef(label = "ID")
	private String id;
	
	@Column(name = "NAME_", length = 60)
	@PropertyDef(label = "任务名称")
	private String name;
	
	@Column(name = "CREATOR_", length = 60)
	@PropertyDef(label = "创建人")
	private String creator;
	
	@Column(name = "CREATE_TIME_")
	@Generator(policy = CreatedDatePolicy.class)
	@PropertyDef(label = "创建时间")
	private Date createDate;
	
	@Column(name = "STATUS_")
	@PropertyDef(label = "是否启用")
	private boolean status;
	
	@Column(name = "URL_", length = 60)
	@PropertyDef(label = "FTP主机地址")
	private String url;
	
	@Column(name = "COLLECT_CATALOG_", length = 60)
	@PropertyDef(label = "采集目录")
	private String collectCatalog;
	
	@Column(name = "PORT_NUMBER_", length = 60)
	@PropertyDef(label = "端口号")
	private String portNumber;
	
	@Column(name = "PROGRAMA_", length = 60)
	@PropertyDef(label = "所属栏目")
	private String programa;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCollectCatalog() {
		return collectCatalog;
	}

	public void setCollectCatalog(String collectCatalog) {
		this.collectCatalog = collectCatalog;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

}
