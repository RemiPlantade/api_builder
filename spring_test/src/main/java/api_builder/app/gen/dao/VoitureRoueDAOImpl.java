package api_builder.app.gen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.gen.dao.iface.VoitureRoueDao;
import api_builder.app.gen.model.VoitureRoue;
import api_builder.app.gen.model.VoitureRoueId;

@Transactional
@Repository
public class VoitureRoueDAOImpl implements VoitureRoueDao{

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void addVoitureRoue(VoitureRoue c) {
		entityManager.persist(c);
	}

	@Override
	public void updateVoitureRoue(VoitureRoue c) {
		VoitureRoue voitRoue = getVoitureRoueById(c.getId());
		voitRoue.setRoue(c.getRoue());
		voitRoue.setVoiture(c.getVoiture());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<VoitureRoue> getAll() {
		String hql = "FROM VoitureRoue as voitureroue ORDER BY voitureroue.id";
		return (List<VoitureRoue>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public VoitureRoue getVoitureRoueById(Object id) {
		return entityManager.find(VoitureRoue.class, id);
	}
	
	@Override
	public List<VoitureRoue> getVoitureRoueByAttr(String attrName, String value) {
		List<VoitureRoue> voitureRoueList = entityManager.createQuery("from VoitureRoue where :attrNAme = :value",VoitureRoue.class)
				.setParameter("atrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return voitureRoueList;
	}

	@Override
	public void deleteVoitureRoue(VoitureRoueId id) {
		VoitureRoue c = getVoitureRoueById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean voitureRoueExists(VoitureRoue c) {
		String hql = "FROM VoitureRoue as voitureRoue WHERE voitureRoue.id = :id";
		int count = entityManager.createQuery(hql)
				.getResultList().size();
		return count > 0 ? true : false;
	}

}
