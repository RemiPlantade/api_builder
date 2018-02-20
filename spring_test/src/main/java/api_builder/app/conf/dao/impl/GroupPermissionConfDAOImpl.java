package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.GroupPermissionConfDao;
import api_builder.app.conf.model.GroupPermissionConf;

@Transactional("tm2")
@Repository
public class GroupPermissionConfDAOImpl implements GroupPermissionConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;

	@Override
	public void addGroupPermissionConf(GroupPermissionConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateGroupPermissionConf(GroupPermissionConf c) {
		GroupPermissionConf upd = getGroupPermissionConfById(c.getId());
		upd.setIdEntityConf(c.getIdEntityConf());
		upd.setIdGroupConf(c.getIdGroupConf());
		upd.setCreation(c.getCreation());
		upd.setDeletion(c.getDeletion());
		upd.setSelection(c.getSelection());
		upd.setUpdating(c.getUpdating());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<GroupPermissionConf> getAll() {
		String hql = "FROM GroupPermissionConf as grouppermissionconf ORDER BY grouppermissionconf.id";
		return (List<GroupPermissionConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public GroupPermissionConf getGroupPermissionConfById(int id) {
		return entityManager.find(GroupPermissionConf.class, id);
	}
	
	@Override
	public List<GroupPermissionConf> getGroupPermissionConfByAttr(String attrName, String value) {
		List<GroupPermissionConf> conducteurList = entityManager.createQuery("from GroupPermissionConf where :attrNAme = :value",GroupPermissionConf.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteGroupPermissionConf(int id) {
		GroupPermissionConf c = getGroupPermissionConfById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean groupPermissionConfExists(GroupPermissionConf c) {
		String hql = "FROM GroupPermissionConf as grouppermissionconf WHERE grouppermissionconf.id = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
