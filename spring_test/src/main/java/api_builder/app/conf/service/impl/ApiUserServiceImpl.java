package api_builder.app.conf.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiUserDao;
import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.service.ApiUserService;
import api_builder.app.conf.service.ApiUserPermService;

@Service
@Transactional
public class ApiUserServiceImpl implements ApiUserService{
	
	@Autowired
	private ApiUserDao apiUserDao;
	
	@Autowired
	private ApiUserPermService userPermService;
	
	@Override
	public void save(ApiUser c) {
		generateDefaultPermissions(apiUserDao.save(c));
	}

	private void generateDefaultPermissions(ApiUser c) {
		userPermService.genDefaultPerm(c);
		
	}

	@Override
	public List<ApiUser> findAll() {
		return (List<ApiUser>) this.apiUserDao.findAll();
	}

	@Override
	public ApiUser findById(int id) {
		return this.apiUserDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		this.apiUserDao.delete(id);
		
	}

	public ApiUserDao getCondDAO() {
		return apiUserDao;
	}

	public void setCondDAO(ApiUserDao condDAO) {
		this.apiUserDao = condDAO;
	}

	@Override
	public boolean tokenExists(String token) {
		// TODO Auto-generated method stub
		return apiUserDao.tokenExists(token);
	}

	@Override
	public List<ApiUser> findAllNotInGroup() {
		// TODO Auto-generated method stub
		return apiUserDao.findAllUserNotInGroup();
	}

	@Override
	public void update(ApiUser user) {
		apiUserDao.save(user);
		
	}
}
