package api_builder.app.conf.dao;

import java.util.List;
import api_builder.app.conf.model.ApiGroupPerm;

public interface ApiGroupPermDao {
	public void save(ApiGroupPerm c);
	public void update(ApiGroupPerm c);
	public List<ApiGroupPerm> findAll();
	public ApiGroupPerm findById(int id);
	public List<ApiGroupPerm> findByAttr(String attrName,String value);
	public void delete(int id);
	public boolean exists(ApiGroupPerm c);
}
