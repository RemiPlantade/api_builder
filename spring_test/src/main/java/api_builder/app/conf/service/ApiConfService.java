package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.ApiConf;
public interface ApiConfService {
	public boolean addApiConf(ApiConf c);
	public void updateApiConf(ApiConf c);
	public List<ApiConf> getAll();
	public ApiConf getApiConfById(int id);
	public List<ApiConf> getApiConfByAttr(String attrName,String value);
	public void deleteApiConf(int id);
}
