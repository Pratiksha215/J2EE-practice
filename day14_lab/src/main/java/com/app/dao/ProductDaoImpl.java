package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

//managed by SC : spring bean
@Repository
public class ProductDaoImpl implements IProductDao {
	//dependency : SF
	@Autowired //byType
	private SessionFactory factory;

	@Override
	public List<Product> getAllProducts() {
		String jpql="select p from Product p";
		return factory.getCurrentSession().createQuery(jpql, Product.class).getResultList();
	}

}
