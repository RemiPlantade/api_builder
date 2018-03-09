package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.model.ApiUserPerm;

@Transactional("tm2")
@Repository
public interface ApiUserPermDao extends CrudRepository<ApiUserPerm, Integer>{
	
	@Query("SELECT p from ApiUserPerm p WHERE apiUser = :user")
	public List<ApiUserPerm> findByUser(@Param("user")ApiUser user);
}
