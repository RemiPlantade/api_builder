package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import api_builder.app.conf.model.UserConf;
import api_builder.app.gen.model.Conducteur;
public interface UserConfDao {
	public void addUser(UserConf c);
	public void updateUser(UserConf c);
	public List<UserConf> getAll();
	public UserConf getUserById(int id);
	public List<UserConf> getUserByAttr(String attrName,String value);
	public void deleteUser(int id);
	public boolean userExists(UserConf c);
}
