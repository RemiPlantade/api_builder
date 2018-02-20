package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.UserConfDao;
import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.service.UserConfService;

@Service
public class UserConfServiceImpl implements UserConfService{
	
	@Autowired
	private UserConfDao userconfDAO;
	
	@Override
	public synchronized boolean addUser(UserConf c) {
		if (userconfDAO.userExists(c)) {
            return false;
        } else {
        	userconfDAO.addUser(c);
            return true;
        }
	}

	@Override
	public void updateUser(UserConf c) {
		this.userconfDAO.updateUser(c);
	}

	@Override
	public List<UserConf> getAll() {
		return this.userconfDAO.getAll();
	}

	@Override
	public UserConf getUserById(int id) {
		return this.userconfDAO.getUserById(id);
	}

	@Override
	public List<UserConf> getUserByAttr(String attrName, String value) {
		return this.userconfDAO.getUserByAttr(attrName, value);
	}

	@Override
	public void deleteUser(int id) {
		this.userconfDAO.deleteUser(id);
		
	}

	public UserConfDao getCondDAO() {
		return userconfDAO;
	}

	public void setCondDAO(UserConfDao condDAO) {
		this.userconfDAO = condDAO;
	}

}
