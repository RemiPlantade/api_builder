package api_builder.app.conf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiBeanDao;
import api_builder.app.conf.dao.ApiUserPermDao;
import api_builder.app.conf.model.ApiBean;
import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.model.ApiUserPerm;
import api_builder.app.conf.model.form.ApiUserPermWrapper;
import api_builder.app.conf.service.ApiUserPermService;

@Service
@Transactional
public class ApiUserPermServiceImpl implements ApiUserPermService{

	@Autowired
	private ApiUserPermDao apiUserPermDao;

	@Autowired
	private ApiBeanDao entityDAO;

	@Override
	public void save(ApiUserPerm c) {
		apiUserPermDao.save(c);
	}

	@Override
	public void update(ApiUserPerm c) {
		this.apiUserPermDao.save(c);
	}

	@Override
	public List<ApiUserPerm> findAll() {
		return (List<ApiUserPerm>) this.apiUserPermDao.findAll();
	}

	@Override
	public ApiUserPerm findById(int id) {
		return this.apiUserPermDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		this.apiUserPermDao.delete(id);

	}

	public ApiUserPermDao getCondDAO() {
		return apiUserPermDao;
	}

	public void setCondDAO(ApiUserPermDao condDAO) {
		this.apiUserPermDao = condDAO;
	}

	@Override
	public void genDefaultPerm(ApiUser user) {
		List<ApiBean> entities = (List<ApiBean>) entityDAO.findAll();
		for (ApiBean entityConf : entities) {
			ApiUserPerm userPerm = new ApiUserPerm();
			userPerm.setApiBean(entityConf);
			userPerm.setApiUser(user);
			userPerm.setCreation(true);
			userPerm.setDeletion(true);
			userPerm.setSelection(true);
			userPerm.setUpdating(true);
			apiUserPermDao.save(userPerm);
		}	
	}

	@Transactional("tm2")
	@Override
	public List<ApiUserPerm> findByUser(ApiUser user) {
		// TODO Auto-generated method stub
		return apiUserPermDao.findByUser(user);
	}

	@Override
	public void updatePermFromWrapper(ApiUserPermWrapper userPermWrapper) {
		for(ApiUserPerm userPerm : userPermWrapper.getUserPermList()) {
			apiUserPermDao.save(userPerm);
		}

	}

}
