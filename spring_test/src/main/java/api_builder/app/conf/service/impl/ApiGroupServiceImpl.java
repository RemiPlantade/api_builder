package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.ApiGroupDao;
import api_builder.app.conf.model.ApiGroup;
import api_builder.app.conf.service.ApiGroupService;

@Service
public class ApiGroupServiceImpl implements ApiGroupService{
	
	@Autowired
	private ApiGroupDao groupconfDAO;
	
	@Override
	public synchronized boolean save(ApiGroup c) {
		if (groupconfDAO.exists(c)) {
            return false;
        } else {
        	groupconfDAO.save(c);
            return true;
        }
	}

	@Override
	public void update(ApiGroup c) {
		this.groupconfDAO.update(c);
	}

	@Override
	public List<ApiGroup> findAll() {
		return this.groupconfDAO.findAll();
	}

	@Override
	public ApiGroup findById(int id) {
		return this.groupconfDAO.findById(id);
	}

	@Override
	public List<ApiGroup> findByAttr(String attrName, String value) {
		return this.groupconfDAO.findByAttr(attrName, value);
	}

	@Override
	public void delete(int id) {
		this.groupconfDAO.delete(id);
		
	}

	public ApiGroupDao getCondDAO() {
		return groupconfDAO;
	}

	public void setCondDAO(ApiGroupDao condDAO) {
		this.groupconfDAO = condDAO;
	}

	@Override
	public ApiGroup findByName(String name) {
		// TODO Auto-generated method stub
		return groupconfDAO.findByName(name);
	}

	@Override
	public void updateById(ApiGroup group, Integer id) {
		this.groupconfDAO.updateById(group,id);
		
	}

}
