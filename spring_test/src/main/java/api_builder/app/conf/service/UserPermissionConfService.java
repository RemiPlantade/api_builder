package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.model.UserPermissionConf;
public interface UserPermissionConfService {
	public boolean addUserPermissionConf(UserPermissionConf c);
	public void updateUserPermissionConf(UserPermissionConf c);
	public List<UserPermissionConf> getAll();
	public UserPermissionConf getUserPermissionConfById(int id);
	public List<UserPermissionConf> getUserPermissionConfByAttr(String attrName,String value);
	public void deleteUserPermissionConf(int id);
	public void generateDefaultPermissions(UserConf c);
	public List<UserPermissionConf> getAllUserPerm(UserConf user);
}
