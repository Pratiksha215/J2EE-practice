package com.example.OnlineShoppingSystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
    private String product_name;
    private String product_info;
    
    @Lob
	@Column(columnDefinition = "MEDIUMBLOB")
    private String product_photo;
    
    
    private String product_state;
    private String product_festival;
    private String product_accessories;
    private int product_price;
    private int product_quantity;
    
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

	public String getProduct_state() {
		return product_state;
	}

	public void setProduct_state(String product_state) {
		this.product_state = product_state;
	}

	public String getProduct_festival() {
		return product_festival;
	}

	public void setProduct_festival(String product_festival) {
		this.product_festival = product_festival;
	}

	public String getProduct_accessories() {
		return product_accessories;
	}

	public void setProduct_accessories(String product_accessories) {
		this.product_accessories = product_accessories;
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

	public Product(int id, String product_name, String product_info, String product_photo, String product_state,
			String product_festival, String product_accessories, int product_price, int product_quantity) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_info = product_info;
		this.product_photo = product_photo;
		this.product_state = product_state;
		this.product_festival = product_festival;
		this.product_accessories = product_accessories;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
