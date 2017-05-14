package com.bstek.cms.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	栏目文档关系表
 * @author bob.yang
 * @since 2017年5月2日
 *
 */
@Entity
@Table(name = "CMS_PROGRAMA_DOCUMENT_LINK")
public class ProgramaDocumentLink implements Serializable {

	private static final long serialVersionUID = -8868907149080358631L;

	@Id
	@Column(name = "ID_", length = 60)
	private String id;

	@Column(name = "PROGRAMA_ID_", length = 60)
	private String programaId;
	
	@Column(name = "DOCUMENT_ID_", length = 60)
	private String documentId;

	@Column(name = "SURVEY_ID_", length = 60)
	private String surveyId;
	
	@Column(name = "ADVERTISEMENT_ID_", length = 60)
	private String advertisementId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProgramaId() {
		return programaId;
	}

	public void setProgramaId(String programaId) {
		this.programaId = programaId;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(String advertisementId) {
		this.advertisementId = advertisementId;
	}

}
