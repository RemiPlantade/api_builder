package api_builder.conf.service;

import java.util.List;

import api_builder.conf.model.ApiUser;
import api_builder.conf.model.ApiUserPerm;
import api_builder.conf.model.form.ApiUserPermWrapper;
public interface ApiUserPermService {
	public void save(ApiUserPerm c);
	public void update(ApiUserPerm c);
	public List<ApiUserPerm> findAll();
	public ApiUserPerm findById(int id);
	public void delete(int id);
	public void genDefaultPerm(ApiUser c);
	public List<ApiUserPerm> findByUser(ApiUser user);
	public void updatePermFromWrapper(ApiUserPermWrapper userPermWrapper);
}
