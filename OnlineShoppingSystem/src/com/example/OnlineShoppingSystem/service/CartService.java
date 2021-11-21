package com.example.OnlineShoppingSystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineShoppingSystem.domain.Cart;
import com.example.OnlineShoppingSystem.repository.CartOperation;
import com.example.OnlineShoppingSystem.repository.CartRepository;


@Service
public class CartService {
	
	@Autowired
   private CartRepository repo;
	
	@Autowired CartOperation cart;
	
	
	public List<Cart> listAll() {
       return repo.findAll();
   }
	
	public void clearCart(int id){		
		cart.clearCart(id);
	}
	
	public List<Cart> getByUser(int id){		
		return cart.getByUser(id);
	}
    
   public void save(Cart std) {
       repo.save(std);
   }
    
   public Cart get(int id) {
       return repo.findById(id).get();
   }
    
   public void delete(int id) {
       repo.deleteById(id);
   }

}