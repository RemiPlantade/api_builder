package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.ApiGroupPermDao;
import api_builder.app.conf.model.ApiGroupPerm;
import api_builder.app.conf.service.ApiGroupPermService;

@Service
public class ApiGroupPermServiceImpl implements ApiGroupPermService{
	
	@Autowired
	private ApiGroupPermDao grouppermissionconfDAO;
	
	@Override
	public synchronized boolean save(ApiGroupPerm c) {
		if (grouppermissionconfDAO.exists(c)) {
            return false;
        } else {
        	grouppermissionconfDAO.save(c);
            return true;
        }
	}

	@Override
	public void update(ApiGroupPerm c) {
		this.grouppermissionconfDAO.update(c);
	}

	@Override
	public List<ApiGroupPerm> findAll() {
		return this.grouppermissionconfDAO.findAll();
	}

	@Override
	public ApiGroupPerm findById(int id) {
		return this.grouppermissionconfDAO.findById(id);
	}

	@Override
	public List<ApiGroupPerm> findByAttr(String attrName, String value) {
		return this.grouppermissionconfDAO.findByAttr(attrName, value);
	}

	@Override
	public void delete(int id) {
		this.grouppermissionconfDAO.delete(id);
		
	}

	public ApiGroupPermDao getCondDAO() {
		return grouppermissionconfDAO;
	}

	public void setCondDAO(ApiGroupPermDao condDAO) {
		this.grouppermissionconfDAO = condDAO;
	}

}
