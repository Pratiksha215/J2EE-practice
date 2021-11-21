package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="projectMapping")
public class ProjectMapping{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectMappingid;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;

	@Column(name = "startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "start-date")
	private LocalDate startDate;
	
	@Column(name = "endDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "end-date")
	private LocalDate endDate;

	public Integer getProjectMappingid() {
		return projectMappingid;
	}

	public void setProjectMappingid(Integer projectMappingid) {
		this.projectMappingid = projectMappingid;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ProjectMapping [projectMappingid=" + projectMappingid + ", personId=" + personId + ", projectId="
				+ projectId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
	
	