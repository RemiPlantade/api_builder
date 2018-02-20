package api_builder.app.conf.service;

import java.util.List;

import api_builder.app.conf.model.EntityConf;
public interface EntityConfService {
	public boolean addEntityConf(EntityConf c);
	public void updateEntityConf(EntityConf c);
	public List<EntityConf> getAll();
	public EntityConf getEntityConfById(int id);
	public List<EntityConf> getEntityConfByAttr(String attrName,String value);
	public void deleteEntityConf(int id);
}
