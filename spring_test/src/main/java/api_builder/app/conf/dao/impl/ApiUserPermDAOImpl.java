package api_builder.app.conf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiUserPermDao;
import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.model.ApiUserPerm;

@Transactional("tm2")
@Repository
public class ApiUserPermDAOImpl implements ApiUserPermDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;
	
	@Autowired
	public ApiUserPermDAOImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(ApiUserPerm.class);
	}

	@Override
	public void save(ApiUserPerm c) {
		entityManager.persist(c);
	}

	@Override
	public void update(ApiUserPerm c) {
		ApiUserPerm updConducter = findById(c.getId());
		updConducter.setCreation(c.getCreation());
		updConducter.setDeletion(c.getDeletion());
		updConducter.setSelection(c.getSelection());
		updConducter.setUpdating(c.getUpdating());
		entityManager.merge(updConducter);
		entityManager.persist(updConducter);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApiUserPerm> findAll() {
		String hql = "FROM ApiUserPerm as apiuserperm ORDER BY apiuserperm.id";
		return (List<ApiUserPerm>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ApiUserPerm findById(int id) {
		return entityManager.find(ApiUserPerm.class, id);
	}
	
	@Override
	public List<ApiUserPerm> findByAttr(String attrName, String value) {
		List<ApiUserPerm> conducteurList = entityManager.createQuery("from ApiUserPerm where :attrNAme = :value",ApiUserPerm.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void delete(int id) {
		ApiUserPerm c = findById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean exists(ApiUserPerm c) {
		String hql = "FROM ApiUserPerm as apiuserperm "
				+ "WHERE apiuserperm.id = :id "
				+ "OR apiuserperm.apiBean = :apibean "
				+ "OR apiuserperm.apiUser = :apiuser";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
				.setParameter("apibean", c.getApiBean())
				.setParameter("apiuser", c.getApiUser())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApiUserPerm> findByUser(ApiUser c) {
		String hql = "FROM ApiUserPerm as apiuserperm WHERE apiuserperm.apiUser = :apiuser";
		List<ApiUserPerm> userPerm = entityManager.createQuery(hql,ApiUserPerm.class)
				.setParameter("apiuser", c)
		        .getResultList();
		return userPerm;
	}

}
