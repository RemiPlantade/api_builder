package api_builder.app.conf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.model.ApiBean;

@Transactional("tm2")
@Repository
public interface ApiBeanDao extends CrudRepository<ApiBean, Integer>{

	@Query("SELECT p FROM ApiBean p WHERE :attrName = :value")
	public List<ApiBean> findByAttr(@Param("attrName") String attrName,@Param("value") String value);
	
}
