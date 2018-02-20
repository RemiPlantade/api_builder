package api_builder.app.conf.dao;

import java.util.List;

import api_builder.app.conf.model.GroupConf;

public interface GroupConfDao {
	public void addGroupConf(GroupConf c);
	public void updateGroupConf(GroupConf c);
	public List<GroupConf> getAll();
	public GroupConf getGroupConfById(int id);
	public List<GroupConf> getGroupConfByAttr(String attrName,String value);
	public void deleteGroupConf(int id);
	public boolean groupConfExists(GroupConf c);
}
