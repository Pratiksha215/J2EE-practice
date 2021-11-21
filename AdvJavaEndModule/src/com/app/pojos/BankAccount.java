package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "iacsd_accts")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acct_id")
	private Integer acctId;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AcType acType;
	private double balance;
	@Column(name = "creation_dt")
	private LocalDate createdOn;
	// many to one, BankAccount : child , owning side(since FK column appears here)
	@ManyToOne 
	@JoinColumn(name="vendor_id",nullable = false)
	private User acctOwner;

	public BankAccount() {
		System.out.println("bank acct constr");
	}

	public BankAccount(AcType acType, double balance, LocalDate createdOn) {
		super();
		this.acType = acType;
		this.balance = balance;
		this.createdOn = createdOn;
	}

	public Integer getAcctId() {
		return acctId;
	}

	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}

	public AcType getAcType() {
		return acType;
	}

	public void setAcType(AcType acType) {
		this.acType = acType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	

	public User getAcctOwner() {
		return acctOwner;
	}

	public void setAcctOwner(User acctOwner) {
		this.acctOwner = acctOwner;
	}

	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", acType=" + acType + ", balance=" + balance + ", createdOn="
				+ createdOn + "]";
	}

}
