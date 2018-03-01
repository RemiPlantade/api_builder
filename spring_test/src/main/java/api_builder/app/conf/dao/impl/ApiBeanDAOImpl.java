package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiBeanDao;
import api_builder.app.conf.model.ApiBean;
import api_builder.app.conf.model.ApiGroupPerm;
import api_builder.app.conf.model.ApiUserPerm;

@Transactional("tm2")
@Repository
public class ApiBeanDAOImpl implements ApiBeanDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;
	
	@Autowired
	public ApiBeanDAOImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(ApiBean.class);
	}

	@Override
	public void save(ApiBean c) {
		entityManager.persist(c);
	}

	@Override
	public void update(ApiBean c) {
		ApiBean updConducter = findById(c.getId());
		updConducter.setName(c.getName());
		updConducter.setManaged(c.getManaged());
		entityManager.merge(updConducter);
		entityManager.persist(updConducter);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApiBean> findAll() {
		String hql = "FROM ApiBean as apibean ORDER BY apibean.id";
		return (List<ApiBean>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ApiBean findById(int id) {
		return entityManager.find(ApiBean.class, id);
	}
	
	@Override
	public List<ApiBean> findByAttr(String attrName, String value) {
		List<ApiBean> conducteurList = entityManager.createQuery("from ApiBean where :attrNAme = :value",ApiBean.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void delete(int id) {
		ApiBean c = findById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean exists(ApiBean c) {
		String hql = "FROM ApiBean as apibean WHERE apibean.id = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
