package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import api_builder.app.conf.model.ApiUser;

public interface ApiUserDao  {
	public ApiUser save(ApiUser c);
	public List<ApiUser> findAll();
	public ApiUser findById(int id);
	public List<ApiUser> findByAttr(String attrName,String value);
	public void delete(int id);
	public boolean exists(ApiUser c);
	public boolean tokenExists(String token);
	public List<ApiUser> findAllUserNotInGroup();
	public void update(ApiUser user);
	
}
