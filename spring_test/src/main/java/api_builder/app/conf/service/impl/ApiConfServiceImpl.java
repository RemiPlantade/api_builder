package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.ApiConfDao;
import api_builder.app.conf.model.ApiConf;
import api_builder.app.conf.service.ApiConfService;

@Service
public class ApiConfServiceImpl implements ApiConfService{
	
	@Autowired
	private ApiConfDao apiconfDAO;
	
	@Override
	public synchronized boolean save(ApiConf c) {
		if (apiconfDAO.exists(c)) {
            return false;
        } else {
        	apiconfDAO.save(c);
            return true;
        }
	}

	@Override
	public void update(ApiConf c) {
		this.apiconfDAO.update(c);
	}

	@Override
	public List<ApiConf> findAll() {
		return this.apiconfDAO.findAll();
	}

	@Override
	public ApiConf findById(int id) {
		return this.apiconfDAO.findById(id);
	}

	@Override
	public List<ApiConf> findByAttr(String attrName, String value) {
		return this.apiconfDAO.findByAttr(attrName, value);
	}

	@Override
	public void delete(int id) {
		this.apiconfDAO.delete(id);
		
	}

	public ApiConfDao getCondDAO() {
		return apiconfDAO;
	}

	public void setCondDAO(ApiConfDao condDAO) {
		this.apiconfDAO = condDAO;
	}

	@Override
	public ApiConf findByParamName(String paramName) {
		// TODO Auto-generated method stub
		return apiconfDAO.findByParamName(paramName);
	}

}
