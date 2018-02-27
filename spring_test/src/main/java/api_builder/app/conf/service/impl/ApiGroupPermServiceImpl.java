package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.app.conf.dao.ApiBeanDao;
import api_builder.app.conf.dao.ApiGroupPermDao;
import api_builder.app.conf.model.ApiBean;
import api_builder.app.conf.model.ApiGroup;
import api_builder.app.conf.model.ApiGroupPerm;
import api_builder.app.conf.model.ApiUserPerm;
import api_builder.app.conf.model.form.ApiGroupPermWrapper;
import api_builder.app.conf.service.ApiGroupPermService;

@Service
public class ApiGroupPermServiceImpl implements ApiGroupPermService{
	
	@Autowired
	private ApiGroupPermDao apiGroupPermDAO;
	
	@Autowired
	private ApiBeanDao entityDAO;
		
	@Override
	public synchronized boolean save(ApiGroupPerm c) {
		if (apiGroupPermDAO.exists(c)) {
            return false;
        } else {
        	apiGroupPermDAO.save(c);
            return true;
        }
	}

	@Override
	public void update(ApiGroupPerm c) {
		this.apiGroupPermDAO.update(c);
	}

	@Override
	public List<ApiGroupPerm> findAll() {
		return this.apiGroupPermDAO.findAll();
	}

	@Override
	public ApiGroupPerm findById(int id) {
		return this.apiGroupPermDAO.findById(id);
	}

	@Override
	public List<ApiGroupPerm> findByAttr(String attrName, String value) {
		return this.apiGroupPermDAO.findByAttr(attrName, value);
	}

	@Override
	public void delete(int id) {
		this.apiGroupPermDAO.delete(id);
		
	}

	public ApiGroupPermDao getCondDAO() {
		return apiGroupPermDAO;
	}

	public void setCondDAO(ApiGroupPermDao condDAO) {
		this.apiGroupPermDAO = condDAO;
	}

	@Override
	public void updatePermFromWrapper(ApiGroupPermWrapper apiGroupPermWrapper) {
		for(ApiGroupPerm groupPerm : apiGroupPermWrapper.getGroupPermList()) {
			apiGroupPermDAO.update(groupPerm);
		}
		
	}
	@Transactional("tm2")
	@Override
	public List<ApiGroupPerm> findByGroup(ApiGroup group) {
		return apiGroupPermDAO.findByGroup(group);
	}

	@Override
	public void genDefaultPerm(ApiGroup apiGroup) {
		List<ApiBean> entities = entityDAO.findAll();
		for (ApiBean entityConf : entities) {
			ApiGroupPerm groupPerm = new ApiGroupPerm();
			groupPerm.setApiBean(entityConf);
			groupPerm.setApiGroup(apiGroup);
			groupPerm.setCreation(true);
			groupPerm.setDeletion(true);
			groupPerm.setSelection(true);
			groupPerm.setUpdating(true);
			apiGroupPermDAO.save(groupPerm);
		}	
	}

}
