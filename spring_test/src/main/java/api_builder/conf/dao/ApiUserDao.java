package api_builder.conf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.conf.model.ApiUser;

@Transactional("tm2")
@Repository
public interface ApiUserDao extends CrudRepository<ApiUser, Integer> {	
	
	@Query("SELECT count(p) > 0 FROM ApiUser p WHERE token = :token")
	public boolean tokenExists(@Param("token")String token);
	
	@Query("SELECT p FROM ApiUser p WHERE group IS NULL")
	public List<ApiUser> findAllUserNotInGroup();
	
}
