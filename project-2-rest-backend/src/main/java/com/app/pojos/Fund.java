package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="iacsd_funds")
public class Fund {

	private Integer id;
	private String name;
	private String company;
	private String desc;
	private FundType type;
	private int quantity;
	private LocalDate publishDate;
	public Fund() {
		System.out.println("in fund constr");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 30,unique=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 30)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(length = 30,name = "fund_desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Enumerated(EnumType.STRING)
	@Column(length=20,name="fund_type")
	public FundType getType() {
		return type;
	}
	public void setType(FundType type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Fund [id=" + id + ", name=" + name + ", company=" + company + ", desc=" + desc + ", type=" + type
				+ ", quantity=" + quantity + ", publishDate=" + publishDate + "]";
	}
	
}
