package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.ApiBeanDao;
import api_builder.app.conf.model.ApiBean;
import api_builder.app.conf.model.ApiUserPerm;
import api_builder.app.conf.model.form.ApiBeanWrapper;
import api_builder.app.conf.service.ApiBeanService;

@Service
public class ApiBeanServiceImpl implements ApiBeanService{
	
	@Autowired
	private ApiBeanDao entityconfDAO;
	
	@Override
	public synchronized boolean save(ApiBean c) {
		if (entityconfDAO.exists(c)) {
            return false;
        } else {
        	entityconfDAO.save(c);
            return true;
        }
	}

	@Override
	public void update(ApiBean c) {
		this.entityconfDAO.update(c);
	}

	@Override
	public List<ApiBean> findAll() {
		return this.entityconfDAO.findAll();
	}

	@Override
	public ApiBean findById(int id) {
		return this.entityconfDAO.findById(id);
	}

	@Override
	public List<ApiBean> findByAttr(String attrName, String value) {
		return this.entityconfDAO.findByAttr(attrName, value);
	}

	@Override
	public void delete(int id) {
		this.entityconfDAO.delete(id);
		
	}

	public ApiBeanDao getCondDAO() {
		return entityconfDAO;
	}

	public void setCondDAO(ApiBeanDao condDAO) {
		this.entityconfDAO = condDAO;
	}

	@Override
	public void updateGroupFromWrapper(ApiBeanWrapper beanWrapper) {
		for(ApiBean apiBean : beanWrapper.getBeanList()) {
			entityconfDAO.update(apiBean);
		}
		
	}

}
