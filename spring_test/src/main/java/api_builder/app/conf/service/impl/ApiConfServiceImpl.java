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
	public synchronized boolean addApiConf(ApiConf c) {
		if (apiconfDAO.apiConfExists(c)) {
            return false;
        } else {
        	apiconfDAO.addApiConf(c);
            return true;
        }
	}

	@Override
	public void updateApiConf(ApiConf c) {
		this.apiconfDAO.updateApiConf(c);
	}

	@Override
	public List<ApiConf> getAll() {
		return this.apiconfDAO.getAll();
	}

	@Override
	public ApiConf getApiConfById(int id) {
		return this.apiconfDAO.getApiConfById(id);
	}

	@Override
	public List<ApiConf> getApiConfByAttr(String attrName, String value) {
		return this.apiconfDAO.getApiConfByAttr(attrName, value);
	}

	@Override
	public void deleteApiConf(int id) {
		this.apiconfDAO.deleteApiConf(id);
		
	}

	public ApiConfDao getCondDAO() {
		return apiconfDAO;
	}

	public void setCondDAO(ApiConfDao condDAO) {
		this.apiconfDAO = condDAO;
	}

}
