package api_builder.app.conf.dao;

import java.util.List;

import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.model.UserPermissionConf;

public interface UserPermissionConfDao {
	public void addUserPermissionConf(UserPermissionConf c);
	public void updateUserPermissionConf(UserPermissionConf c);
	public List<UserPermissionConf> getAll();
	public UserPermissionConf getUserPermissionConfById(int id);
	public List<UserPermissionConf> getUserPermissionConfByAttr(String attrName,String value);
	public void deleteUserPermissionConf(int id);
	public boolean userPermissionConfExists(UserPermissionConf c);
	public List<UserPermissionConf> getAllUserPerm(UserConf c);
}
