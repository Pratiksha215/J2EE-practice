package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

//managed by SC : spring bean
@Repository
public class ProductDaoImpl implements IProductDao {
	//dependency : javax.persistence.EntityManager:i/f : equivalent to org.hibernate.Session
	@PersistenceContext
	private EntityManager mgr;//JPA anno.

	@Override
	public List<Product> getAllProducts() {
		String jpql="select p from Product p";
		return mgr.createQuery(jpql, Product.class).getResultList();
	}

	@Override
	public String deleteProduct(int propductId) {
		String mesg="product deletion failed";
		
		Product p=mgr.find(Product.class, propductId);
		if(p != null)
		{
			mgr.remove(p);
			mesg="product deleted successfully";
		}
		return mesg;
	}

	@Override
	public String addProduct(Product transientProduct) {
		String mesg="Product added successfully";
		mgr.persist(transientProduct);
		return mesg;
	}
	

}
