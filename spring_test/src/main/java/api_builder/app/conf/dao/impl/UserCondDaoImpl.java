package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.UserConfDao;
import api_builder.app.conf.model.UserConf;

@Repository
@Transactional("tm2")
public class UserCondDaoImpl implements UserConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private final EntityManager entityManager;

	@Autowired
	public UserCondDaoImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(UserConf.class);
	}


	@Override
	public void addUserConf(UserConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateUserConf(UserConf c) {
		UserConf updConducter = getUserConfById(c.getId());
		updConducter.setUsername(c.getUsername());
		updConducter.setMail(c.getMail());
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
		String hql = "FROM UserConf as userconf WHERE userconf.id = :id OR userconf.mail = :mail";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
				.setParameter("mail", c.getMail())
				.getResultList().size();
		return count > 0 ? true : false;
	}


	@Override
	public boolean tokenExists(String token) {
		String hql = "FROM UserConf as userconf WHERE userconf.token = :token";
		int count = entityManager.createQuery(hql)
				.setParameter("token", token)
				.getResultList().size();
		return count > 0 ? true : false;
	}
}
