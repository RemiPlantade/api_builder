package org.api_builder.services;

import org.api_builder.beans.User;

public interface UserService {
	public User saveUser(User user);
	public User getUserById(int id);
	public User getUserByUserId(String userId);
}
