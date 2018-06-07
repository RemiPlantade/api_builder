
package api_builder.gen.dao;
import api_builder.gen.bean.Voiture;
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
 * Home object for domain model class Voiture.
 * @see api_builder.gen.bean.Voiture
 * @author Hibernate Tools
 */
public interface VoitureDao extends CrudRepository<Voiture, Integer>{
	@Query("SELECT p FROM Voiture p WHERE :attrName = :value")
	public List<Voiture> findByAttr(@Param("attrName") String attrName,@Param("value") String value);
}

