package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service // mandatory : To tell SC : this layer contains B.L methods
@Transactional//mandatory :  To tell SC : this layer contains automatic tx management logic
public class UserServiceImpl implements IUserService {
	//dependent  obj : service
	//dependency : dao (i/f ) : to avoid tight coupling
	@Autowired
	private IUserDao dao;

	@Override
	public User authenticateUser(String email, String pwd) {
		System.out.println("in service : auth ");
		return dao.authenticateUser(email, pwd);
	}

}
