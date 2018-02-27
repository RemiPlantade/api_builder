package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiGroupPermDao;
import api_builder.app.conf.model.ApiConf;
import api_builder.app.conf.model.ApiGroupPerm;

@Transactional("tm2")
@Repository
public class ApiGroupPermDAOImpl implements ApiGroupPermDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;
	
	@Autowired
	public ApiGroupPermDAOImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(ApiGroupPerm.class);
	}

	@Override
	public void save(ApiGroupPerm c) {
		entityManager.persist(c);
	}

	@Override
	public void update(ApiGroupPerm c) {
		ApiGroupPerm upd = findById(c.getId());
		upd.setApiBean(c.getApiBean());
		upd.setApiGroup(c.getApiGroup());
		upd.setCreation(c.getCreation());
		upd.setDeletion(c.getDeletion());
		upd.setSelection(c.getSelection());
		upd.setUpdating(c.getUpdating());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApiGroupPerm> findAll() {
		String hql = "FROM ApiGroupPerm as apigroupperm ORDER BY apigroupperm.id";
		return (List<ApiGroupPerm>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ApiGroupPerm findById(int id) {
		return entityManager.find(ApiGroupPerm.class, id);
	}
	
	@Override
	public List<ApiGroupPerm> findByAttr(String attrName, String value) {
		List<ApiGroupPerm> conducteurList = entityManager.createQuery("from ApiGroupPerm where :attrNAme = :value",ApiGroupPerm.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void delete(int id) {
		ApiGroupPerm c = findById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean exists(ApiGroupPerm c) {
		String hql = "FROM ApiGroupPerm as apigroupperm WHERE "
				+ "apigroupperm.id = :id "
				+ "OR apigroupperm.apiBean = :apibean "  
				+ "OR apigroupperm.apiGroup = :apigroup ";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
				.setParameter("apibean", c.getApiBean())
				.setParameter("apigroup", c.getApiGroup())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
