package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.ApiGroup;
public interface ApiGroupService {
	public void save(ApiGroup c);
	public void update(ApiGroup c);
	public List<ApiGroup> findAll();
	public ApiGroup findById(int id);
	public void delete(int id);
	public ApiGroup findByName(String name);
}
