package com.example.OnlineShoppingSystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name="cart")
@Entity(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
    private String product_name;
    private String product_info;
    
    @Lob
	@Column(columnDefinition = "MEDIUMBLOB")
    private String product_photo;
    
    private int product_price;
    private int product_quantity;
    private int product_total;
    
    @Column(name="user_id")
    private int user_id;
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public String getProduct_photo() {
		return product_photo;
	}

	public void setProduct_photo(String product_photo) {
		this.product_photo = product_photo;
	}


	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	

	public int getProduct_total() {
		return product_total;
	}

	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}

	public Cart(int id, String product_name, String product_info, String product_photo, int product_price,
			int product_quantity, int product_total, int user_id) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_info = product_info;
		this.product_photo = product_photo;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_total = product_total;
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
