package com.app.dao;

import java.util.List;

import com.app.pojos.Product;

public interface IProductDao {
	List<Product> getAllProducts();
	String deleteProduct(int propductId);
	String addProduct(Product transientProduct);
	Product getProductDetails(int pid);
	
}
