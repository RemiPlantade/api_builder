package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.EntityConfDao;
import api_builder.app.conf.model.EntityConf;
import api_builder.app.conf.model.GroupPermissionConf;

@Transactional("tm2")
@Repository
public class EntityConfDAOImpl implements EntityConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;
	
	@Autowired
	public EntityConfDAOImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(EntityConf.class);
	}

	@Override
	public void addEntityConf(EntityConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateEntityConf(EntityConf c) {
		EntityConf updConducter = getEntityConfById(c.getId());
		updConducter.setName(c.getName());
		updConducter.setManaged(c.getManaged());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EntityConf> getAll() {
		String hql = "FROM EntityConf as entityconf ORDER BY entityconf.id";
		return (List<EntityConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public EntityConf getEntityConfById(int id) {
		return entityManager.find(EntityConf.class, id);
	}
	
	@Override
	public List<EntityConf> getEntityConfByAttr(String attrName, String value) {
		List<EntityConf> conducteurList = entityManager.createQuery("from EntityConf where :attrNAme = :value",EntityConf.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteEntityConf(int id) {
		EntityConf c = getEntityConfById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean entityConfExists(EntityConf c) {
		String hql = "FROM EntityConf as entityconf WHERE entityconf.id = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
