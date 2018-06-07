package api_builder.conf.service;

import java.util.List;

import api_builder.conf.model.ApiBean;
import api_builder.conf.model.form.ApiBeanWrapper;

public interface ApiBeanService {
	public void save(ApiBean c);
	public void update(ApiBean c);
	public List<ApiBean> findAll();
	public ApiBean findById(int id);
	public List<ApiBean> findByAttr(String attrName,String value);
	public void delete(int id);
	public void updateGroupFromWrapper(ApiBeanWrapper beanWrapper);
}