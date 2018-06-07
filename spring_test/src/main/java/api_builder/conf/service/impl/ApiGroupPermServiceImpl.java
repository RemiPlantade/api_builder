package api_builder.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.conf.dao.ApiBeanDao;
import api_builder.conf.dao.ApiGroupPermDao;
import api_builder.conf.model.ApiBean;
import api_builder.conf.model.ApiGroup;
import api_builder.conf.model.ApiGroupPerm;
import api_builder.conf.model.ApiUserPerm;
import api_builder.conf.model.form.ApiGroupPermWrapper;
import api_builder.conf.service.ApiGroupPermService;

@Service
@Transactional
public class ApiGroupPermServiceImpl implements ApiGroupPermService{

	@Autowired
	private ApiGroupPermDao apiGroupPermDAO;

	@Autowired
	private ApiBeanDao entityDAO;

	@Override
	public void save(ApiGroupPerm c) {
		apiGroupPermDAO.save(c);
	}

	@Override
	public void update(ApiGroupPerm c) {
		this.apiGroupPermDAO.save(c);
	}

	@Override
	public List<ApiGroupPerm> findAll() {
		return (List<ApiGroupPerm>) this.apiGroupPermDAO.findAll();
	}

	@Override
	public ApiGroupPerm findById(int id) {
		return this.apiGroupPermDAO.findOne(id);
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
			apiGroupPermDAO.save(groupPerm);
		}

	}
	@Transactional("tm2")
	@Override
	public List<ApiGroupPerm> findByGroup(ApiGroup group) {
		return apiGroupPermDAO.findByGroup(group);
	}

	@Override
	public void genDefaultPerm(ApiGroup apiGroup) {
		List<ApiBean> entities = (List<ApiBean>) entityDAO.findAll();
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
