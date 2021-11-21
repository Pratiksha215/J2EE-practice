package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.pojos.Product;
@Service
@Transactional

public class ProductServiceImpl implements IProductService {
	//dependency
	@Autowired
	private IProductDao dao;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		System.out.println("dao imple class"+dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public Optional<Product> getProductDetails(String pName) {
		// TODO Auto-generated method stub
		return dao.findByName(pName);
	}

}
