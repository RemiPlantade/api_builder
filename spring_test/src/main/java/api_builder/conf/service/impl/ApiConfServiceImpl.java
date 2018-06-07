package api_builder.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api_builder.conf.dao.ApiConfDao;
import api_builder.conf.model.ApiConf;
import api_builder.conf.model.form.ApiConfWrapper;
import api_builder.conf.service.ApiConfService;

@Service
@Transactional
public class ApiConfServiceImpl implements ApiConfService{

	@Autowired
	private ApiConfDao apiconfDAO;

	@Override
	public void save(ApiConf c) {
			apiconfDAO.save(c);
	}

	@Override
	public void update(ApiConf c) {
		this.apiconfDAO.save(c);
	}

	@Override
	public List<ApiConf> findAll() {
		return (List<ApiConf>) this.apiconfDAO.findAll();
	}

	@Override
	public ApiConf findById(int id) {
		return this.apiconfDAO.findOne(id);
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
		return apiconfDAO.findByKey(paramName);
	}

	@Override
	public void updateConfFromWrapper(ApiConfWrapper apiConfWrapper) {
		for (ApiConf apiConf : apiConfWrapper.getApiConfList()) {
			apiconfDAO.save(apiConf);
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
