package api_builder.app.conf.dao;

import java.util.List;
import api_builder.app.conf.model.ApiConf;

public interface ApiConfDao {
	public void addApiConf(ApiConf c);
	public void updateApiConf(ApiConf c);
	public List<ApiConf> getAll();
	public ApiConf getApiConfById(int id);
	public List<ApiConf> getApiConfByAttr(String attrName,String value);
	public void deleteApiConf(int id);
	public boolean apiConfExists(ApiConf c);
}
