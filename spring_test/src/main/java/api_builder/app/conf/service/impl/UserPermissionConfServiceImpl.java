package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.UserPermissionConfDao;
import api_builder.app.conf.model.UserPermissionConf;
import api_builder.app.conf.service.UserPermissionConfService;

@Service
public class UserPermissionConfServiceImpl implements UserPermissionConfService{
	
	@Autowired
	private UserPermissionConfDao userpermissionconfDAO;
	
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

}
