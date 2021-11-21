package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface IProductService {
	List<Product> getAllProducts();
	String deleteProduct(int propductId);
	String addProduct(Product transientProduct);
	Product getProductDetails(int pid);
}
