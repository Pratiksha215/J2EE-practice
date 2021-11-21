package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

//spring bean : SC
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	//dependency : dao i/f
	@Autowired
	private IProductDao dao;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public String deleteProduct(int propductId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(propductId);
	}

	@Override
	public String addProduct(Product transientProduct) {
		// TODO Auto-generated method stub
		return dao.addProduct(transientProduct);
	}

	@Override
	public Product getProductDetails(int pid) {
		// TODO Auto-generated method stub
		return dao.getProductDetails(pid);
	}
	
	

}
