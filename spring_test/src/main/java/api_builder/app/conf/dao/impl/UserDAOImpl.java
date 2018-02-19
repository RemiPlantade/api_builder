package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.UserDao;
import api_builder.app.conf.model.User;

@Transactional("tm2")
@Repository
public class UserDAOImpl implements UserDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;

	@Override
	public void addUser(User c) {
		entityManager.persist(c);
	}

	@Override
	public void updateUser(User c) {
		User updConducter = getUserById(c.getId());
		updConducter.setFirstname(c.getFirstname());
		updConducter.setLastname(c.getLastname());
		updConducter.setToken(c.getToken());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String hql = "FROM User as cond ORDER BY cond.id";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	
	@Override
	public List<User> getUserByAttr(String attrName, String value) {
		List<User> conducteurList = entityManager.createQuery("from User where :attrNAme = :value",User.class)
				.setParameter("atrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteUser(int id) {
		User c = getUserById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean userExists(User c) {
		String hql = "FROM User as cond WHERE cond.idconducteur = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
