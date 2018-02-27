package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.ApiBean;
public interface ApiBeanService {
	public boolean save(ApiBean c);
	public void update(ApiBean c);
	public List<ApiBean> findAll();
	public ApiBean findById(int id);
	public List<ApiBean> findByAttr(String attrName,String value);
	public void delete(int id);
}
