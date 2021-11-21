package com.example.OnlineShoppingSystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineShoppingSystem.domain.Login;
import com.example.OnlineShoppingSystem.repository.LoginRepository;


@Service
public class LoginService {
	
	@Autowired
   private LoginRepository repo;
	
	  public Login login(String username, String password) {
		  Login user = repo.findByUsernameAndPassword(username, password);
	  	return user;
	  }
	  public Login login() {
		 Login user =new Login();
	  	return user;
	  }
		
}