package api_builder.app.conf.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.UserConfDao;
import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.service.UserConfService;
import api_builder.app.conf.service.UserPermissionConfService;

@Service
public class UserConfServiceImpl implements UserConfService{
	
	@Resource
	private UserConfDao userconfDAO;
	
	@Resource
	private UserPermissionConfService userPermService;
	
	@Override
	@Transactional("tm2")
	public boolean addUserConf(UserConf c) {
		if (userconfDAO.userConfExists(c)) {
            return false;
        } else {
        	generateDefaultPermissions(userconfDAO.addUserConf(c));
            return true;
        }
	}

	private void generateDefaultPermissions(UserConf c) {
		userPermService.generateDefaultPermissions(c);
		
	}

	@Override
	public List<UserConf> getAll() {
		return this.userconfDAO.getAll();
	}

	@Override
	public UserConf getUserConfById(int id) {
		return this.userconfDAO.getUserConfById(id);
	}

	@Override
	public List<UserConf> getUserConfByAttr(String attrName, String value) {
		return this.userconfDAO.getUserConfByAttr(attrName, value);
	}

	@Override
	public void deleteUserConf(int id) {
		this.userconfDAO.deleteUserConf(id);
		
	}

	public UserConfDao getCondDAO() {
		return userconfDAO;
	}

	public void setCondDAO(UserConfDao condDAO) {
		this.userconfDAO = condDAO;
	}

	@Override
	public boolean tokenExists(String token) {
		// TODO Auto-generated method stub
		return userconfDAO.tokenExists(token);
	}

	@Override
	public List<UserConf> getAllUsersNotINGroup() {
		// TODO Auto-generated method stub
		return userconfDAO.getAllUsersNotINGroup();
	}

	@Override
	public void updateUserConf(UserConf user, Integer id) {
		userconfDAO.updateUserConf(user, id);
		
	}
}
