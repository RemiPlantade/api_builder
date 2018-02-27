package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.ApiUser;
public interface ApiUserService {
	public boolean save(ApiUser c);
	public List<ApiUser> findAll();
	public ApiUser findById(int id);
	public List<ApiUser> findByAttr(String attrName,String value);
	public void delete(int id);
	public boolean tokenExists(String token);
	public List<ApiUser> findAllNotInGroup();
	public void update(ApiUser user);
}
