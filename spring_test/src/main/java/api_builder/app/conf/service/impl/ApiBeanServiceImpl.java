package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiBeanDao;
import api_builder.app.conf.model.ApiBean;
import api_builder.app.conf.model.form.ApiBeanWrapper;
import api_builder.app.conf.service.ApiBeanService;

@Service
@Transactional
public class ApiBeanServiceImpl implements ApiBeanService{
	
	@Autowired
	private ApiBeanDao entityconfDAO;
	
	@Override
	public void save(ApiBean c) {
        	entityconfDAO.save(c);
	}

	@Override
	public void update(ApiBean c) {
		this.entityconfDAO.save(c);
	}

	@Override
	public List<ApiBean> findAll() {
		return (List<ApiBean>) this.entityconfDAO.findAll();
	}

	@Override
	public ApiBean findById(int id) {
		return this.entityconfDAO.findOne(id);
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
			entityconfDAO.save(apiBean);
		}
		
	}

}
