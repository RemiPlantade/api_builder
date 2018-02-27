package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiGroupDao;
import api_builder.app.conf.model.ApiBean;
import api_builder.app.conf.model.ApiGroup;
import api_builder.app.conf.model.ApiUser;

@Transactional("tm2")
@Repository
public class ApiGroupDAOImpl implements ApiGroupDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;
	
	@Autowired
	public ApiGroupDAOImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(ApiGroup.class);
	}

	@Override
	public ApiGroup save(ApiGroup c) {
		entityManager.persist(c);
		return findById(c.getId());
	}

	@Override
	public void update(ApiGroup c) {
		ApiGroup updGroupConf = findById(c.getId());
		updGroupConf.setName(c.getName());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApiGroup> findAll() {
		String hql = "FROM ApiGroup as apigroup ORDER BY apigroup.id";
		return (List<ApiGroup>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ApiGroup findById(int id) {
		return entityManager.find(ApiGroup.class, id);
	}
	
	@Override
	public List<ApiGroup> findByAttr(String attrName, String value) {
		List<ApiGroup> conducteurList = entityManager.createQuery("from apigroup where :attrNAme = :value",ApiGroup.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void delete(int id) {
		ApiGroup c = findById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean exists(ApiGroup c) {
		String hql = "FROM ApiGroup as apigroup WHERE apigroup.id = :id OR apigroup.name = :name";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
				.setParameter("name", c.getName())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public ApiGroup findByName(String name) {
		// TODO Auto-generated method stub
		return (ApiGroup) entityManager.createQuery("FROM ApiGroup as apigroup WHERE apigroup.name = :name")
				.setParameter("name", name)
				.getSingleResult();
	}

	@Override
	public void updateById(ApiGroup group, Integer id) {
		ApiGroup original = entityManager.find(ApiGroup.class, id);
		original.setName(group.getName());
		entityManager.merge(original);
		entityManager.persist(original);
	}

}
