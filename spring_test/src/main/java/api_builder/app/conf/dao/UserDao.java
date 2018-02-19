package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import api_builder.app.conf.model.User;
import api_builder.app.gen.model.Conducteur;
public interface UserDao {
	public void addUser(User c);
	public void updateUser(User c);
	public List<User> getAll();
	public User getUserById(int id);
	public List<User> getUserByAttr(String attrName,String value);
	public void deleteUser(int id);
	public boolean userExists(User c);
}
