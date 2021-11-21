package com.example.OnlineShoppingSystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineShoppingSystem.domain.Product;
import com.example.OnlineShoppingSystem.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
   private ProductRepository repo;
	
	public List<Product> listAll() {
       return repo.findAll();
   }
    
   public void save(Product std) {
       repo.save(std);
   }
    
   public Product get(int id) {
       return repo.findById(id).get();
   }
    
   public void delete(int id) {
       repo.deleteById(id);
   }

}