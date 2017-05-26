package org.api_builder.services.impl;

import org.api_builder.beans.User;
import org.api_builder.dao.UserDao;
import org.api_builder.dao.impl.UserDaoImpl;
import org.api_builder.services.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	public UserServiceImpl() {
		super();
		userDao = new UserDaoImpl();
	}
	@Override
	public User getUserById(int id) {
		
		return userDao.findById(id);
	}

	@Override
	public User getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return userDao.findByUserId(userId);
	}
	@Override
	public User saveUser(User user) {
		return userDao.addUser(user);
	}
}
