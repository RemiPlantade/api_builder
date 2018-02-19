package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.User;
public interface UserService {
	public boolean addUser(User c);
	public void updateUser(User c);
	public List<User> getAll();
	public User getUserById(int id);
	public List<User> getUserByAttr(String attrName,String value);
	public void deleteUser(int id);
}
