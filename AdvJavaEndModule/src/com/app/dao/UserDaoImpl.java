package com.app.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;


@Repository //mandatory : spring bean : singleton n eager
public class UserDaoImpl implements IUserDao {
	//which is dependency of DAO layer ?
	@Autowired //byType
	private SessionFactory sf;
	

	@Override
	public String registerVendor(User transientVendor) {
		String mesg="Vendor reg failed";
		sf.getCurrentSession().persist(transientVendor);
		mesg="Vendor reg successful , ID : "+transientVendor.getId();
		return mesg;
	}

	@Override
	public User authenticateUser(String email1, String pwd1) {
		String jpql="select u from User u where u.email =:em and u.password=:pa";
		
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email1).
				setParameter("pa", pwd1).getSingleResult();
	}
	

}
