package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiConfDao;
import api_builder.app.conf.model.ApiConf;
import api_builder.app.conf.model.ApiUser;

@Transactional("tm2")
@Repository
public class ApiConfDAOImpl implements ApiConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;

	@Autowired
	public ApiConfDAOImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(ApiConf.class);
	}

	@Override
	public void save(ApiConf c) {
		entityManager.persist(c);
	}

	@Override
	public void update(ApiConf c) {
		ApiConf original = findById(c.getId());
		original.setParamName(c.getParamName());
		original.setParamValue(c.getParamValue());
		original.setParamType(c.getParamType());
		entityManager.merge(original);
		entityManager.persist(original);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApiConf> findAll() {
		String hql = "FROM ApiConf as apiconf ORDER BY apiconf.id";
		return (List<ApiConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ApiConf findById(int id) {
		return entityManager.find(ApiConf.class, id);
	}

	@Override
	public List<ApiConf> findByAttr(String attrName, String value) {
		List<ApiConf> conducteurList = entityManager.createQuery("from ApiConf where :attrNAme = :value",ApiConf.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void delete(int id) {
		ApiConf c = findById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean exists(ApiConf c) {
		String hql = "FROM ApiConf as apiconf WHERE apiconf.id = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
				.getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public ApiConf findByParamName(String paramName) {
		String hql = "FROM ApiConf as apiconf WHERE apiconf.paramName = :paramName";
		return entityManager.createQuery(hql,ApiConf.class)
				.setParameter("paramName", paramName).getSingleResult();
	}

	@Override
	public ApiConf findByKey(String paramKey) {
		String hql = "FROM ApiConf as apiconf WHERE apiconf.paramKey = :paramKey";
		return entityManager.createQuery(hql,ApiConf.class)
				.setParameter("paramKey", paramKey).getSingleResult();
	}

}
