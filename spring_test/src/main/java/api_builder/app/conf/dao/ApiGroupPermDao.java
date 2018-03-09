package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.model.ApiGroup;
import api_builder.app.conf.model.ApiGroupPerm;

@Transactional("tm2")
@Repository
public interface ApiGroupPermDao extends CrudRepository<ApiGroupPerm, Integer> {
	
	@Query("SELECT p FROM ApiGroupPerm p WHERE apiGroup = :group")
	public List<ApiGroupPerm> findByGroup(@Param("group") ApiGroup group);
}
