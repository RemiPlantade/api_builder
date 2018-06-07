package api_builder.conf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.conf.model.ApiConf;

@Transactional("tm2")
@Repository
public interface ApiConfDao extends CrudRepository<ApiConf, Integer>{

	@Query("SELECT p FROM ApiConf p WHERE paramKey = :key")
	public ApiConf findByKey(@Param("key")String key);
	
	@Query("SELECT p FROM ApiConf p WHERE modifiable = 1")
	public List<ApiConf> findAllModifiable();
}
