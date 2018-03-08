package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.ApiConfDao;
import api_builder.app.conf.model.ApiConf;
import api_builder.app.conf.model.form.ApiConfWrapper;
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
	public ApiConf findByParamKey(String paramName) {
		// TODO Auto-generated method stub
		return apiconfDAO.findByParamKey(paramName);
	}

	@Override
	public void updateConfFromWrapper(ApiConfWrapper apiConfWrapper) {
		for (ApiConf apiConf : apiConfWrapper.getApiConfList()) {
			System.out.println("Update Conf : " + apiConf.getParamKey() + " = " + apiConf.getParamValue() + " added : " + apiConf.isAdded());
			apiconfDAO.update(apiConf);
		}

	}

	@Override
	public ApiConf findByKey(String paramName) {
		// TODO Auto-generated method stub
		return apiconfDAO.findByKey(paramName);
	}

	@Override
	public List<ApiConf> findAllModifiable() {
		return this.apiconfDAO.findAllModifiable();
	}
	@Override
	public ApiConf updateServerPort(ApiConfWrapper apiConfWrapper) {
		ApiConf httpsEnable = null;
		ApiConf newHttpPort = null;
		ApiConf newHttpsPort = null;
		ApiConf serverPort = findByKey("server.port");

		for (ApiConf apiConf : apiConfWrapper.getApiConfList()) {
			httpsEnable = apiConf.getParamKey().equals("server.ssl.enabled") ? apiConf : httpsEnable;
			newHttpPort = apiConf.getParamKey().equals("api.port.http") ? apiConf : newHttpPort;
			newHttpsPort = apiConf.getParamKey().equals("api.port.https") ? apiConf : newHttpsPort;
		}
		if(httpsEnable.getParamValue().equals("true")) {
			serverPort.setParamValue(newHttpsPort.getParamValue());
		}else if(httpsEnable.getParamValue().equals("false")) {
			serverPort.setParamValue(newHttpPort.getParamValue());
		}
		apiConfWrapper.getApiConfList().add(serverPort);
		return serverPort;

	}
	@Override
	public void saveActualPorts(ApiConfWrapper apiConfWrapper) {
		// Get actual port values
		String actualServerPort = findByParamKey("server.port").getParamValue();
		// Get new port values
		ApiConf newServerPort = null;
		for (ApiConf apiConf : apiConfWrapper.getApiConfList()) {
			newServerPort = apiConf.getParamKey().equals("server.port") ? apiConf : newServerPort;
		}
		// If they are changed on form update old port value with actual
		if(!newServerPort.equals(actualServerPort)) {
			ApiConf prevServerPort = findByKey("previous.api.port");
			prevServerPort.setParamValue(actualServerPort);
			apiConfWrapper.getApiConfList().add(prevServerPort);
		}

	}
	@Override
	public ApiConfWrapper getApiConfWrapper() {
		ApiConfWrapper apiconfWrapper = new ApiConfWrapper();
		apiconfWrapper.setApiConfList(findAllModifiable());
		return apiconfWrapper;
	}

	@Override
	public void manageHTTPSConfig(ApiConfWrapper apiConfWrapper) {
		ApiConf httpsEnable = null;
		ApiConf keyStoreFile = null;
		ApiConf keyStorePwd = null;
		ApiConf keyStoreType = null;
		ApiConf keyAlias = null;
		for (ApiConf apiConf : apiConfWrapper.getApiConfList()) {
			httpsEnable = apiConf.getParamKey().equals("server.ssl.enabled") ? apiConf : httpsEnable;
			keyStoreFile = apiConf.getParamKey().equals("server.ssl.key-store")? apiConf : keyStoreFile;
			keyStorePwd = apiConf.getParamKey().equals("server.ssl.key-store-password")? apiConf : keyStorePwd;
			keyStoreType = apiConf.getParamKey().equals("server.ssl.key-store-type")? apiConf : keyStoreType;
			keyAlias = apiConf.getParamKey().equals("server.ssl.key-alias")? apiConf : keyAlias;
		}
		keyStoreFile.setAdded(httpsEnable.getParamValue().equals("true"));
		keyStorePwd.setAdded(httpsEnable.getParamValue().equals("true"));
		keyStoreType.setAdded(httpsEnable.getParamValue().equals("true"));
		keyAlias.setAdded(httpsEnable.getParamValue().equals("true"));
	}
	
	
}
