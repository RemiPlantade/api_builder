package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import api_builder.app.conf.model.UserConf;
import api_builder.app.gen.model.Conducteur;
public interface UserConfDao {
	public void addUserConf(UserConf c);
	public void updateUserConf(UserConf c);
	public List<UserConf> getAll();
	public UserConf getUserConfById(int id);
	public List<UserConf> getUserConfByAttr(String attrName,String value);
	public void deleteUserConf(int id);
	public boolean userConfExists(UserConf c);
}
