package com.example.OnlineShoppingSystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineShoppingSystem.domain.AdminLogin;
import com.example.OnlineShoppingSystem.repository.AdminLoginRepository;


@Service
public class AdminLoginService {
	
	@Autowired
   private AdminLoginRepository repo;
	
	  public AdminLogin login(String username, String password) {
		  AdminLogin user = repo.findByUsernameAndPassword(username, password);
	  	return user;
	  }
	  public AdminLogin login() {
		 AdminLogin user =new AdminLogin();
	  	return user;
	  }
		
}