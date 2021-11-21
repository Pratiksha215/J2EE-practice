package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
String registerVendor(User transientVendor);
User authenticateUser(String email,String pwd);
}
