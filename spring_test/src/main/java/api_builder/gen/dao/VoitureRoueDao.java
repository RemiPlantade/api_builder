
package api_builder.gen.dao;
import api_builder.gen.bean.VoitureRoue;
import api_builder.gen.bean.VoitureRoueId;
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
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.bean.VoitureRoue
 * @author Hibernate Tools
 */
public interface VoitureRoueDao extends CrudRepository<VoitureRoue, VoitureRoueId>{
	@Query("SELECT p FROM VoitureRoue p WHERE :attrName = :value")
	public List<VoitureRoue> findByAttr(@Param("attrName") String attrName,@Param("value") String value);
}

