package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.GroupConf;
public interface GroupConfService {
	public boolean addGroupConf(GroupConf c);
	public void updateGroupConf(GroupConf c);
	public List<GroupConf> getAll();
	public GroupConf getGroupConfById(int id);
	public List<GroupConf> getGroupConfByAttr(String attrName,String value);
	public void deleteGroupConf(int id);
	public GroupConf getGroupConfByName(String name);
	public void updateGroupConf(GroupConf group, Integer id);
}
