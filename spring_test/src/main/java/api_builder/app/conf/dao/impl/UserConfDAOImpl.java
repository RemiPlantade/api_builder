package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.UserConfDao;
import api_builder.app.conf.model.UserConf;

@Transactional("tm2")
@Repository
public class UserConfDAOImpl implements UserConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;

	@Override
	public void addUser(UserConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateUser(UserConf c) {
		UserConf updConducter = getUserById(c.getId());
		updConducter.setFirstname(c.getFirstname());
		updConducter.setLastname(c.getLastname());
		updConducter.setToken(c.getToken());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserConf> getAll() {
		String hql = "FROM UserConf as cond ORDER BY cond.id";
		return (List<UserConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public UserConf getUserById(int id) {
		return entityManager.find(UserConf.class, id);
	}
	
	@Override
	public List<UserConf> getUserByAttr(String attrName, String value) {
		List<UserConf> conducteurList = entityManager.createQuery("from UserConf where :attrNAme = :value",UserConf.class)
				.setParameter("atrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteUser(int id) {
		UserConf c = getUserById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean userExists(UserConf c) {
		String hql = "FROM UserConf as cond WHERE cond.idconducteur = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
