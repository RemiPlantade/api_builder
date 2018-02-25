package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.GroupConfDao;
import api_builder.app.conf.model.EntityConf;
import api_builder.app.conf.model.GroupConf;

@Transactional("tm2")
@Repository
public class GroupConfDAOImpl implements GroupConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;
	
	@Autowired
	public GroupConfDAOImpl(JpaContext context) {
		this.entityManager = context.getEntityManagerByManagedType(GroupConf.class);
	}

	@Override
	public void addGroupConf(GroupConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateGroupConf(GroupConf c) {
		GroupConf updGroupConf = getGroupConfById(c.getId());
		updGroupConf.setName(c.getName());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<GroupConf> getAll() {
		String hql = "FROM GroupConf as groupconf ORDER BY groupconf.id";
		return (List<GroupConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public GroupConf getGroupConfById(int id) {
		return entityManager.find(GroupConf.class, id);
	}
	
	@Override
	public List<GroupConf> getGroupConfByAttr(String attrName, String value) {
		List<GroupConf> conducteurList = entityManager.createQuery("from GroupConf where :attrNAme = :value",GroupConf.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteGroupConf(int id) {
		GroupConf c = getGroupConfById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean groupConfExists(GroupConf c) {
		String hql = "FROM GroupConf as groupconf WHERE groupconf.id= = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
