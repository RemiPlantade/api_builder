
package api_builder.gen.dao;
import api_builder.gen.bean.Roue;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


@Transactional("tm1")
@Repository
/**
 * Home object for domain model class Roue.
 * @see api_builder.gen.bean.Roue
 * @author Hibernate Tools
 */
public interface RoueDao extends CrudRepository<Roue, Integer>{
	@Query("SELECT p FROM Roue p WHERE :attrName = :value")
	public List<Roue> findByAttr(@Param("attrName") String attrName,@Param("value") String value);
}

