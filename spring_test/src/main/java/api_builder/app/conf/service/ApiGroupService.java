package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.ApiGroup;
public interface ApiGroupService {
	public boolean save(ApiGroup c);
	public void update(ApiGroup c);
	public List<ApiGroup> findAll();
	public ApiGroup findById(int id);
	public List<ApiGroup> findByAttr(String attrName,String value);
	public void delete(int id);
	public ApiGroup findByName(String name);
	public void updateById(ApiGroup group, Integer id);
}
