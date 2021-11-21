package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="projects")
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	@Column(length = 30,unique = true)
	private String projectName;
	@Column(name = "startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "start-date")
	private LocalDate startDate;
	@Column(name = "targetEndDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "target-end-date")
	private LocalDate targetEndDate;
	@Column(name = "actualEndDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "actual-end-date")
	private LocalDate actualEndDate;
	@Column(name = "createdOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "created-on")
	private LocalDate createdOn;
	@Column(length = 30)
	private String createdBy;
	@Column(name = "modifiedOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "modified-on")
	private LocalDate modifiedOn;
	@Column(length = 30)
	private String modifiedBy;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getTargetEndDate() {
		return targetEndDate;
	}
	public void setTargetEndDate(LocalDate targetEndDate) {
		this.targetEndDate = targetEndDate;
	}
	public LocalDate getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(LocalDate actualEndDate) {
		this.actualEndDate = actualEndDate;
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
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", targetEndDate=" + targetEndDate + ", actualEndDate=" + actualEndDate + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + ", modifiedOn=" + modifiedOn + ", modifiedBy=" + modifiedBy + "]";
	}
	
	
	
}