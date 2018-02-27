package api_builder.app.conf.dao;

import java.util.List;

import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.model.ApiUserPerm;

public interface ApiUserPermDao {
	public void save(ApiUserPerm c);
	public void update(ApiUserPerm c);
	public List<ApiUserPerm> findAll();
	public ApiUserPerm findById(int id);
	public List<ApiUserPerm> findByAttr(String attrName,String value);
	public void delete(int id);
	public boolean exists(ApiUserPerm c);
	public List<ApiUserPerm> findByUser(ApiUser c);
}
