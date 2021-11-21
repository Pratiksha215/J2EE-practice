package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.service.IProductService;

@RestController // =>@Controller at class level +
//@ResponseBody anno added on ret types of all req handling methods
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService service;

	public ProductController() {
		System.out.println("In cont of" + getClass().getName());
	}

	// RESTFul endpoint or API end point or API provider
	@GetMapping
	public ResponseEntity<?> listAllProducts() {
		System.out.println("in list all product");
		// invoke service layer's method: controller -->service impl (p) -->JPA repos
		// impl class(SC)
		List<Product> list = service.getAllProducts();
		if (list.isEmpty())
			// empty product list : set sts code : HTTP 204(no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK , send the list
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// get product details by its name : supplied by clnt using path var
	@GetMapping("/{productName}")
	public ResponseEntity<?> getProductDetails(@PathVariable String productName) {
		System.out.println("in get prod details" + productName);
		// invoke service method
		Optional<Product> productDetails = service.getProductDetails(productName);
		//
		if (productDetails.isPresent())
			return new ResponseEntity<>(productDetails.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}