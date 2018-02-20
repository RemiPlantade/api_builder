package api_builder.app.conf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.UserPermissionConfDao;
import api_builder.app.conf.model.UserPermissionConf;

@Transactional("tm2")
@Repository
public class UserPermissionConfDAOImpl implements UserPermissionConfDao{

	@PersistenceContext(unitName="confEntityManager")
	private EntityManager entityManager;

	@Override
	public void addUserPermissionConf(UserPermissionConf c) {
		entityManager.persist(c);
	}

	@Override
	public void updateUserPermissionConf(UserPermissionConf c) {
		UserPermissionConf updConducter = getUserPermissionConfById(c.getId());
		updConducter.setIdEntityConf(c.getIdEntityConf());
		updConducter.setIdUserConf(c.getIdUserConf());
		updConducter.setCreation(c.getCreation());
		updConducter.setDeletion(c.getDeletion());
		updConducter.setSelection(c.getSelection());
		updConducter.setUpdating(c.getUpdating());
		entityManager.flush();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserPermissionConf> getAll() {
		String hql = "FROM UserPermissionConf as userPermissionconf ORDER BY userpermissionconf.id";
		return (List<UserPermissionConf>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public UserPermissionConf getUserPermissionConfById(int id) {
		return entityManager.find(UserPermissionConf.class, id);
	}
	
	@Override
	public List<UserPermissionConf> getUserPermissionConfByAttr(String attrName, String value) {
		List<UserPermissionConf> conducteurList = entityManager.createQuery("from UserPermissionConf where :attrNAme = :value",UserPermissionConf.class)
				.setParameter("attrName", attrName)
				.setParameter("value", value)
				.getResultList();
		return conducteurList;
	}

	@Override
	public void deleteUserPermissionConf(int id) {
		UserPermissionConf c = getUserPermissionConfById(id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	public boolean userPermissionConfExists(UserPermissionConf c) {
		String hql = "FROM UserPermissionConf as userpermissionconf WHERE userPermissionconf.id = :id";
		int count = entityManager.createQuery(hql)
				.setParameter("id", c.getId())
		        .getResultList().size();
		return count > 0 ? true : false;
	}

}
