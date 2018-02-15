package api_builder.app.gen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.gen.dao.iface.RoueDao;
import api_builder.app.gen.model.Roue;

@Transactional
@Repository
public class RoueDAOImpl implements RoueDao{

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void addRoue(Roue c) {
		entityManager.persist(c);
	}

	@Override
	public void updateRoue(Roue c) {
		Roue roue = getRoueById(c.getId());
		roue.setLargeur(c.getLargeur());
		roue.setRayon(c.getRayon());
		roue.setVoitureRoues(c.getVoitureRoues());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Roue> getAll() {
		String hql = "FROM Roue as roue ORDER BY roue.id";
		return (List<Roue>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Roue getRoueById(int id) {
		return entityManager.find(Roue.class, id);
	}
	
	@Override
	public List<Roue> getRoueByAttr(String attrName, String value) {
		List<Roue> conducteurList = entityManager.createQuery("from Roue where :attrNAme = :value",Roue.class)
				.setParameter("atrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteRoue(int id) {
		Roue c = getRoueById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean roueExists(Roue c) {
		String hql = "FROM Roue as cond WHERE idroue = :idroue";
		int count = entityManager.createQuery(hql)
				.setParameter(":idroue", c.getId())
				.getResultList().size();
		return count > 0 ? true : false;
	}

}
