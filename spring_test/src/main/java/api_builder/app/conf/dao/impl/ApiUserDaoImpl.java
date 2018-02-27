package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiUserDao;
import api_builder.app.conf.dao.ApiUserPermDao;
import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.model.ApiUserPerm;

@Repository
@Transactional("tm2")
public class ApiUserDaoImpl implements ApiUserDao{

	@PersistenceContext(unitName="confEntityManager")
	private final EntityManager entityManager;
	
	@Autowired
	public ApiUserDaoImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(ApiUser.class);
	}

	@Override
	public ApiUser save(ApiUser c) {
		entityManager.persist(c);
		return findById(c.getId());
	}

	@Override
	public List<ApiUser> findAll() {
		String hql = "FROM ApiUser as apiuser ORDER BY apiuser.id";
		return  entityManager.createQuery(hql,ApiUser.class).getResultList();
	}

	@Override
	public ApiUser findById(int id) {
		return entityManager.find(ApiUser.class, id);
	}

	@Override
	public List<ApiUser> findByAttr(String attrName, String value) {
		List<ApiUser> conducteurList = entityManager.createQuery("from ApiUser where :attrName = :value",ApiUser.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void delete(int id) {
		ApiUser c = findById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean exists(ApiUser c) {
		String hql = "FROM ApiUser as apiuser WHERE apiuser.id = :id OR apiuser.username = :username";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
				.setParameter("username", c.getUsername())
				.getResultList().size();
		return count > 0 ? true : false;
	}


	@Override
	public boolean tokenExists(String token) {
		String hql = "FROM ApiUser as apiuser WHERE apiuser.token = :token";
		int count = entityManager.createQuery(hql)
				.setParameter("token", token)
				.getResultList().size();
		return count > 0 ? true : false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ApiUser> findAllUserNotInGroup() {
		String hql = "FROM ApiUser as apiuser WHERE apiuser.group = null";
		return entityManager.createQuery(hql)
				.getResultList();
	}
	
	@Override
	@Transactional("tm2")
	public void update(ApiUser user) {
		ApiUser original = entityManager.find(ApiUser.class, user.getId());
		original.setMail(user.getMail());
		original.setUsername(user.getUsername());
		original.setGroup(user.getGroup());
		original.setMaxquota(user.getMaxquota());
		entityManager.merge(original);
		entityManager.persist(original);
	}
}
