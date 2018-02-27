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
public class ApiUserPermServiceImpl implements ApiUserPermService{
	
	@Resource
	private ApiUserPermDao userpermissionconfDAO;
	
	@Resource
	private ApiBeanDao entityDAO;
	
	@Override
	public synchronized boolean save(ApiUserPerm c) {
		if (userpermissionconfDAO.exists(c)) {
            return false;
        } else {
        	userpermissionconfDAO.save(c);
            return true;
        }
	}

	@Override
	public void update(ApiUserPerm c) {
		this.userpermissionconfDAO.update(c);
	}

	@Override
	public List<ApiUserPerm> findAll() {
		return this.userpermissionconfDAO.findAll();
	}

	@Override
	public ApiUserPerm findById(int id) {
		return this.userpermissionconfDAO.findById(id);
	}

	@Override
	public List<ApiUserPerm> findByAttr(String attrName, String value) {
		return this.userpermissionconfDAO.findByAttr(attrName, value);
	}

	@Override
	public void delete(int id) {
		this.userpermissionconfDAO.delete(id);
		
	}

	public ApiUserPermDao getCondDAO() {
		return userpermissionconfDAO;
	}

	public void setCondDAO(ApiUserPermDao condDAO) {
		this.userpermissionconfDAO = condDAO;
	}

	@Override
	public void genDefaultPerm(ApiUser user) {
		List<ApiBean> entities = entityDAO.findAll();
		for (ApiBean entityConf : entities) {
			ApiUserPerm userPerm = new ApiUserPerm();
			System.out.println(user.getId());
			System.out.println(entityConf.getName());
			userPerm.setApiBean(entityConf);
			userPerm.setApiUser(user);
			userPerm.setCreation(true);
			userPerm.setDeletion(true);
			userPerm.setSelection(true);
			userPerm.setUpdating(true);
			userpermissionconfDAO.save(userPerm);
		}	
	}

	@Transactional("tm2")
	@Override
	public List<ApiUserPerm> findByUser(ApiUser user) {
		// TODO Auto-generated method stub
		return userpermissionconfDAO.findByUser(user);
	}

	@Override
	public void updatePermFromWrapper(ApiUserPermWrapper userPermWrapper) {
		for(ApiUserPerm userPerm : userPermWrapper.getUserPermList()) {
			userpermissionconfDAO.update(userPerm);
		}
		
	}

}
