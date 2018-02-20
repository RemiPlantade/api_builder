package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.UserConf;
public interface UserConfService {
	public boolean addUser(UserConf c);
	public void updateUser(UserConf c);
	public List<UserConf> getAll();
	public UserConf getUserById(int id);
	public List<UserConf> getUserByAttr(String attrName,String value);
	public void deleteUser(int id);
}
