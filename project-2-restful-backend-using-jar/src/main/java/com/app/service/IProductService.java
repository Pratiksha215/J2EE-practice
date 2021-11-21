package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Product;

public interface IProductService {
	//list all products
	List<Product> getAllProducts();
	// get product details by name
	Optional<Product>getProductDetails(String pName);
	

}
