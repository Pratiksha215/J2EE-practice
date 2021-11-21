package com.example.OnlineShoppingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineShoppingSystem.domain.AdminLogin;


@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, Long>{
	AdminLogin findByUsernameAndPassword(String username, String password);
 
}