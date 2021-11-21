package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="people")
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	@Column(length = 30)
	private String personName;
	@Column(length = 30,unique = true)
	private String personEmail;
	 @Enumerated(EnumType.STRING)
	private PersonRole role;
	private int assignedProjects;
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
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public PersonRole getRole() {
		return role;
	}
	public void setRole(PersonRole role) {
		this.role = role;
	}
	public int getAssignedProjects() {
		return assignedProjects;
	}
	public void setAssignedProjects(int assignedProjects) {
		this.assignedProjects = assignedProjects;
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
		return "People [personId=" + personId + ", personName=" + personName + ", personEmail=" + personEmail
				+ ", role=" + role + ", assignedProjects=" + assignedProjects + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + ", modifiedOn=" + modifiedOn + ", modifiedBy=" + modifiedBy + "]";
	}
	
	
}
