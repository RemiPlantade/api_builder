package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import api_builder.app.conf.model.UserConf;

public interface UserConfDao  {
	public void addUserConf(UserConf c);
	public void updateUserConf(UserConf c);
	public List<UserConf> getAll();
	public UserConf getUserConfById(int id);
	public List<UserConf> getUserConfByAttr(String attrName,String value);
	public void deleteUserConf(int id);
	public boolean userConfExists(UserConf c);
	public boolean tokenExists(String token);
	
}
