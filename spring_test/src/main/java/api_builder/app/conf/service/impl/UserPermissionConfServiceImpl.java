package api_builder.app.conf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.EntityConfDao;
import api_builder.app.conf.dao.UserPermissionConfDao;
import api_builder.app.conf.model.EntityConf;
import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.model.UserPermissionConf;
import api_builder.app.conf.service.UserPermissionConfService;

@Service
public class UserPermissionConfServiceImpl implements UserPermissionConfService{
	
	@Resource
	private UserPermissionConfDao userpermissionconfDAO;
	
	@Resource
	private EntityConfDao entityDAO;
	
	@Override
	public synchronized boolean addUserPermissionConf(UserPermissionConf c) {
		if (userpermissionconfDAO.userPermissionConfExists(c)) {
            return false;
        } else {
        	userpermissionconfDAO.addUserPermissionConf(c);
            return true;
        }
	}

	@Override
	public void updateUserPermissionConf(UserPermissionConf c) {
		this.userpermissionconfDAO.updateUserPermissionConf(c);
	}

	@Override
	public List<UserPermissionConf> getAll() {
		return this.userpermissionconfDAO.getAll();
	}

	@Override
	public UserPermissionConf getUserPermissionConfById(int id) {
		return this.userpermissionconfDAO.getUserPermissionConfById(id);
	}

	@Override
	public List<UserPermissionConf> getUserPermissionConfByAttr(String attrName, String value) {
		return this.userpermissionconfDAO.getUserPermissionConfByAttr(attrName, value);
	}

	@Override
	public void deleteUserPermissionConf(int id) {
		this.userpermissionconfDAO.deleteUserPermissionConf(id);
		
	}

	public UserPermissionConfDao getCondDAO() {
		return userpermissionconfDAO;
	}

	public void setCondDAO(UserPermissionConfDao condDAO) {
		this.userpermissionconfDAO = condDAO;
	}

	@Override
	public void generateDefaultPermissions(UserConf user) {
		List<EntityConf> entities = entityDAO.getAll();
		for (EntityConf entityConf : entities) {
			UserPermissionConf userPerm = new UserPermissionConf();
			System.out.println(user.getId());
			System.out.println(entityConf.getName());
			userPerm.setIdEntityConf(entityConf);
			userPerm.setIdUserConf(user);
			userPerm.setCreation(true);
			userPerm.setDeletion(true);
			userPerm.setSelection(true);
			userPerm.setDeletion(true);
			userpermissionconfDAO.addUserPermissionConf(userPerm);
		}	
	}

	@Transactional("tm2")
	@Override
	public List<UserPermissionConf> getAllUserPerm(UserConf user) {
		// TODO Auto-generated method stub
		return userpermissionconfDAO.getAllUserPerm(user);
	}

}
