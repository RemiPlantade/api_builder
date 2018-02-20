package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiConfDao;
import api_builder.app.conf.model.ApiConf;

@Transactional("tm2")
@Repository
public class ApiConfDAOImpl implements ApiConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;

	@Override
	public void addApiConf(ApiConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateApiConf(ApiConf c) {
		ApiConf updConducter = getApiConfById(c.getId());
		updConducter.setParamName(c.getParamName());
		updConducter.setParamValue(c.getParamValue());
		updConducter.setParamType(c.getParamType());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApiConf> getAll() {
		String hql = "FROM ApiConf as apiconf ORDER BY apiconf.id";
		return (List<ApiConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ApiConf getApiConfById(int id) {
		return entityManager.find(ApiConf.class, id);
	}
	
	@Override
	public List<ApiConf> getApiConfByAttr(String attrName, String value) {
		List<ApiConf> conducteurList = entityManager.createQuery("from ApiConf where :attrNAme = :value",ApiConf.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteApiConf(int id) {
		ApiConf c = getApiConfById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean apiConfExists(ApiConf c) {
		String hql = "FROM ApiConf as apiconf WHERE apiconf.id = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
