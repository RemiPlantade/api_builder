package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.UserDao;
import api_builder.app.conf.model.User;
import api_builder.app.conf.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDAO;
	
	@Override
	public synchronized boolean addUser(User c) {
		if (userDAO.userExists(c)) {
            return false;
        } else {
        	userDAO.addUser(c);
            return true;
        }
	}

	@Override
	public void updateUser(User c) {
		this.userDAO.updateUser(c);
	}

	@Override
	public List<User> getAll() {
		return this.userDAO.getAll();
	}

	@Override
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	public List<User> getUserByAttr(String attrName, String value) {
		return this.userDAO.getUserByAttr(attrName, value);
	}

	@Override
	public void deleteUser(int id) {
		this.userDAO.deleteUser(id);
		
	}

	public UserDao getCondDAO() {
		return userDAO;
	}

	public void setCondDAO(UserDao condDAO) {
		this.userDAO = condDAO;
	}

}
