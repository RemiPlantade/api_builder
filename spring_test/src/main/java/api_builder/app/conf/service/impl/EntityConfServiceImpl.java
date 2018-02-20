package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.EntityConfDao;
import api_builder.app.conf.model.EntityConf;
import api_builder.app.conf.service.EntityConfService;

@Service
public class EntityConfServiceImpl implements EntityConfService{
	
	@Autowired
	private EntityConfDao entityconfDAO;
	
	@Override
	public synchronized boolean addEntityConf(EntityConf c) {
		if (entityconfDAO.entityConfExists(c)) {
            return false;
        } else {
        	entityconfDAO.addEntityConf(c);
            return true;
        }
	}

	@Override
	public void updateEntityConf(EntityConf c) {
		this.entityconfDAO.updateEntityConf(c);
	}

	@Override
	public List<EntityConf> getAll() {
		return this.entityconfDAO.getAll();
	}

	@Override
	public EntityConf getEntityConfById(int id) {
		return this.entityconfDAO.getEntityConfById(id);
	}

	@Override
	public List<EntityConf> getEntityConfByAttr(String attrName, String value) {
		return this.entityconfDAO.getEntityConfByAttr(attrName, value);
	}

	@Override
	public void deleteEntityConf(int id) {
		this.entityconfDAO.deleteEntityConf(id);
		
	}

	public EntityConfDao getCondDAO() {
		return entityconfDAO;
	}

	public void setCondDAO(EntityConfDao condDAO) {
		this.entityconfDAO = condDAO;
	}

}
