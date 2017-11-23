package api_builder.app.gen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.gen.dao.iface.ConducteurDao;
import api_builder.app.gen.model.Conducteur;

@Transactional
@Repository
public class ConducteurDAOImpl implements ConducteurDao{

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void addConducteur(Conducteur c) {
		entityManager.persist(c);
	}

	@Override
	public void updateConducteur(Conducteur c) {
		Conducteur updConducter = getConducteurById(c.getIdconducteur());
		updConducter.setAge(c.getAge());
		updConducter.setNom(c.getNom());
		updConducter.setPrenom(c.getPrenom());
//		updConducter.setVoitures(c.getVoitures());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Conducteur> getAll() {
		String hql = "FROM Conducteur as cond ORDER BY cond.idconducteur";
		return (List<Conducteur>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Conducteur getConducteurById(int id) {
		return entityManager.find(Conducteur.class, id);
	}
	
	@Override
	public List<Conducteur> getConducteurByAttr(String attrName, String value) {
		List<Conducteur> conducteurList = entityManager.createQuery("from Conducteur where :attrNAme = :value",Conducteur.class)
				.setParameter("atrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteConducteur(int id) {
		Conducteur c = getConducteurById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean conducteurExists(Conducteur c) {
		String hql = "FROM Conducteur as cond WHERE cond.prenom = :prenom and cond.nom = :nom and cond.age = :age";
		int count = entityManager.createQuery(hql)
				.setParameter(":prenom", c.getPrenom())
				.setParameter(":nom", c.getNom())
				.setParameter(":age", c.getAge())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
