package api_builder.app.conf.dao;

import java.util.List;
import api_builder.app.conf.model.EntityConf;

public interface EntityConfDao {
	public void addEntityConf(EntityConf c);
	public void updateEntityConf(EntityConf c);
	public List<EntityConf> getAll();
	public EntityConf getEntityConfById(int id);
	public List<EntityConf> getEntityConfByAttr(String attrName,String value);
	public void deleteEntityConf(int id);
	public boolean entityConfExists(EntityConf c);
}
