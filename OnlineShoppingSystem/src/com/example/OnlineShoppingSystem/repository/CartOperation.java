package com.example.OnlineShoppingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineShoppingSystem.domain.Cart;


@Repository
@Transactional
public interface CartOperation extends CrudRepository<Cart, Integer> {

	@Modifying
	@Query(value= "delete from cart WHERE user_id = :id")
	public void clearCart(@Param("id")int id);
	
	
	@Query(value= "select * from cart WHERE user_id = :id", nativeQuery = true)
	public List<Cart> getByUser(@Param("id")int id);
	
	
}