package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.ApiConf;
public interface ApiConfService {
	public boolean save(ApiConf c);
	public void update(ApiConf c);
	public List<ApiConf> findAll();
	public ApiConf findById(int id);
	public List<ApiConf> findByAttr(String attrName,String value);
	public void delete(int id);
}
