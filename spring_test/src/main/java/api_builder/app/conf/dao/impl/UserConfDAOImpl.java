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
	public void addUserConf(UserConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateUserConf(UserConf c) {
		UserConf updConducter = getUserConfById(c.getId());
		updConducter.setFirstname(c.getFirstname());
		updConducter.setLastname(c.getLastname());
		updConducter.setToken(c.getToken());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserConf> getAll() {
		String hql = "FROM UserConf as userconf ORDER BY userconf.id";
		return (List<UserConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public UserConf getUserConfById(int id) {
		return entityManager.find(UserConf.class, id);
	}
	
	@Override
	public List<UserConf> getUserConfByAttr(String attrName, String value) {
		List<UserConf> conducteurList = entityManager.createQuery("from UserConf where :attrNAme = :value",UserConf.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteUserConf(int id) {
		UserConf c = getUserConfById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean userConfExists(UserConf c) {
		String hql = "FROM UserConf as userconf WHERE userconf.id = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
