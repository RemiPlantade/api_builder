package api_builder.conf.service;

import java.util.List;

import api_builder.conf.model.ApiGroup;
import api_builder.conf.model.ApiGroupPerm;
import api_builder.conf.model.form.ApiGroupPermWrapper;

public interface ApiGroupPermService {
	public void save(ApiGroupPerm c);
	public void update(ApiGroupPerm c);
	public List<ApiGroupPerm> findAll();
	public ApiGroupPerm findById(int id);
	public void delete(int id);
	public void updatePermFromWrapper(ApiGroupPermWrapper apiGroupPermWrapper);
	public List<ApiGroupPerm> findByGroup(ApiGroup group);
	public void genDefaultPerm(ApiGroup apiGroup);
}
