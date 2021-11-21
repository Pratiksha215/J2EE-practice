package com.app.pojos;
//id(Integer),name,email,password,reg amount,reg date (LocalDate),role (enum --vendor / admin)

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="iacsd_vendors")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 30)
	private String password;
	private double regAmount;
	private LocalDate regDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role role;
	//Bi -dir association between 2 entities Vendor 1<---->n BankAccount
	//mappedBy : attribute of @OneToMany 
	//where : inverse side (one)
	//value : name of the asso property as it appears in the owning side(BankAccount) : acctOwner
	//cascade = CascadeType.ALL => cascade all ops (insert/update/delete) from parent ---> child
	@OneToMany(mappedBy = "acctOwner",cascade = CascadeType.ALL)
	private List<BankAccount> accts=new ArrayList<>();//Assigning to empty AL : optional BUT reco 
	//by founder (Gavin King) : to avoid null pointer exc while adding new accts

	public User() {
		System.out.println("in vendor constr");
	}

	public User(String name, String email, String password, double regAmount, LocalDate regDate, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public List<BankAccount> getAccts() {
		return accts;
	}

	public void setAccts(List<BankAccount> accts) {
		this.accts = accts;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", regAmount="
				+ regAmount + ", regDate=" + regDate + ", role=" + role + "]";
	}
	
}
