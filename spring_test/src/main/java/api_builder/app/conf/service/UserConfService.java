package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.UserConf;
public interface UserConfService {
	public boolean addUserConf(UserConf c);
	public List<UserConf> getAll();
	public UserConf getUserConfById(int id);
	public List<UserConf> getUserConfByAttr(String attrName,String value);
	public void deleteUserConf(int id);
	public boolean tokenExists(String token);
	public List<UserConf> getAllUsersNotINGroup();
	public void updateUserConf(UserConf user, Integer id);
}
