package api_builder.app.conf.dao;

import java.util.List;
import api_builder.app.conf.model.ApiConf;

public interface ApiConfDao {
	public void save(ApiConf c);
	public void update(ApiConf c);
	public List<ApiConf> findAll();
	public ApiConf findById(int id);
	public List<ApiConf> findByAttr(String attrName,String value);
	public void delete(int id);
	public boolean exists(ApiConf c);
	public ApiConf findByParamName(String paramName);
	public ApiConf findByKey(String paramName);
	public List<ApiConf> findAllModifiable();
}
