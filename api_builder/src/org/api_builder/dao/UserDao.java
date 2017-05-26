package org.api_builder.dao;

import java.util.List;

import org.api_builder.beans.User;

public interface UserDao {
	
	public User findById(int id);
	
	public User findByUserId(String userId);
	
	public User addUser(User user);
	
	public List<User> getAllUsers();
}
