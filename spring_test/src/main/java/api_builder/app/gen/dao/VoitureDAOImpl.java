package api_builder.app.gen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.gen.dao.iface.VoitureDao;
import api_builder.app.gen.model.Voiture;

@Transactional
@Repository
public class VoitureDAOImpl implements VoitureDao{

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void addVoiture(Voiture v) {
		entityManager.persist(v);
	}

	@Override
	public void updateVoiture(Voiture v) {
		Voiture updVoiture = getVoitureById(v.getId());
		updVoiture.setConducteur(v.getConducteur());
		updVoiture.setDatecircul(v.getDatecircul());
		updVoiture.setImmat(v.getImmat());
		updVoiture.setMarque(v.getMarque());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> getAll() {
		String hql = "FROM Voiture as voit ORDER BY voit.id";
		return (List<Voiture>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Voiture getVoitureById(int id) {
		return entityManager.find(Voiture.class, id);
	}

	@Override
	public List<Voiture> getVoitureByAttr(String attrName, String value) {
		List<Voiture> voitureList = entityManager.createQuery("from Voiture where :attrNAme = :value",Voiture.class)
				.setParameter("atrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return voitureList;
	}

	@Override
	public void deleteVoiture(int id) {
		Voiture v = getVoitureById(id);
		if(v != null) {
			entityManager.remove(v);
		}
	}

	@Override
	public boolean voitureExists(Voiture v) {
		String hql = "FROM Voiture as voit WHERE voit.immat = :immat";
		int count = entityManager.createQuery(hql)
				.setParameter("immat", v.getImmat())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
