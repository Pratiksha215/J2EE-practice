package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="issues")
public class Issues {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer issueId;
	private String issueSummary;
	private String issueDescription;
	private Integer identifiedBypersonId;//foreignKey
	@Column(name = "identifiedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "identified-date")
	private LocalDate identifiedDate;
	private Integer relatedProjects;
	private Integer assignedTo;
	 @Enumerated(EnumType.STRING)
	private issueStatus status;
	 @Enumerated(EnumType.STRING)
	private issuePriority priority;
	@Column(name = "targetResolutionDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "target-resolution-date")
	private LocalDate targetResolutionDate;
	private String progress;
	@Column(name = "actualResolutionDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "actual-resolution-date")
	private LocalDate actualResolutionDate;
	private String resolutionSummary;
	@Column(name = "createdOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "created-on")
	private LocalDate createdOn;
	private String createdBy;
	@Column(name = "modifiedOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "modified-on")
	private LocalDate modifiedOn;
	private String modifiedBy;
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getIssueSummary() {
		return issueSummary;
	}
	public void setIssueSummary(String issueSummary) {
		this.issueSummary = issueSummary;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public Integer getIdentifiedBypersonId() {
		return identifiedBypersonId;
	}
	public void setIdentifiedBypersonId(Integer identifiedBypersonId) {
		this.identifiedBypersonId = identifiedBypersonId;
	}
	public LocalDate getIdentifiedDate() {
		return identifiedDate;
	}
	public void setIdentifiedDate(LocalDate identifiedDate) {
		this.identifiedDate = identifiedDate;
	}
	public Integer getRelatedProjects() {
		return relatedProjects;
	}
	public void setRelatedProjects(Integer relatedProjects) {
		this.relatedProjects = relatedProjects;
	}
	public Integer getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(Integer assignedTo) {
		this.assignedTo = assignedTo;
	}
	public issueStatus getStatus() {
		return status;
	}
	public void setStatus(issueStatus status) {
		this.status = status;
	}
	public issuePriority getPriority() {
		return priority;
	}
	public void setPriority(issuePriority priority) {
		this.priority = priority;
	}
	public LocalDate getTargetResolutionDate() {
		return targetResolutionDate;
	}
	public void setTargetResolutionDate(LocalDate targetResolutionDate) {
		this.targetResolutionDate = targetResolutionDate;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public LocalDate getActualResolutionDate() {
		return actualResolutionDate;
	}
	public void setActualResolutionDate(LocalDate actualResolutionDate) {
		this.actualResolutionDate = actualResolutionDate;
	}
	public String getResolutionSummary() {
		return resolutionSummary;
	}
	public void setResolutionSummary(String resolutionSummary) {
		this.resolutionSummary = resolutionSummary;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "Issues [issueId=" + issueId + ", issueSummary=" + issueSummary + ", issueDescription="
				+ issueDescription + ", identifiedBypersonId=" + identifiedBypersonId + ", identifiedDate="
				+ identifiedDate + ", relatedProjects=" + relatedProjects + ", assignedTo=" + assignedTo + ", status="
				+ status + ", priority=" + priority + ", targetResolutionDate=" + targetResolutionDate + ", progress="
				+ progress + ", actualResolutionDate=" + actualResolutionDate + ", resolutionSummary="
				+ resolutionSummary + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", modifiedOn="
				+ modifiedOn + ", modifiedBy=" + modifiedBy + "]";
	}
	
	
}
	
	
	
	