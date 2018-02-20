package api_builder.app.conf.dao;

import java.util.List;
import api_builder.app.conf.model.GroupPermissionConf;

public interface GroupPermissionConfDao {
	public void addGroupPermissionConf(GroupPermissionConf c);
	public void updateGroupPermissionConf(GroupPermissionConf c);
	public List<GroupPermissionConf> getAll();
	public GroupPermissionConf getGroupPermissionConfById(int id);
	public List<GroupPermissionConf> getGroupPermissionConfByAttr(String attrName,String value);
	public void deleteGroupPermissionConf(int id);
	public boolean groupPermissionConfExists(GroupPermissionConf c);
}
