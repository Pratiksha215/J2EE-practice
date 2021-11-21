package com.example.OnlineShoppingSystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineShoppingSystem.domain.User;
import com.example.OnlineShoppingSystem.repository.UserRepository;


@Service
public class RegisterService {
	
	@Autowired
   private UserRepository repo;
	
	public List<User> listAll() {
       return repo.findAll();
   }
    
   public void save(User std) {
       repo.save(std);
   }
    
   public User get(int id) {
       return repo.findById(id).get();
   }
    
   public void delete(int id) {
       repo.deleteById(id);
   }
   

}