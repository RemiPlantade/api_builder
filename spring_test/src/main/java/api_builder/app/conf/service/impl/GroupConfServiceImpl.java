package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.GroupConfDao;
import api_builder.app.conf.model.GroupConf;
import api_builder.app.conf.service.GroupConfService;

@Service
public class GroupConfServiceImpl implements GroupConfService{
	
	@Autowired
	private GroupConfDao groupconfDAO;
	
	@Override
	public synchronized boolean addGroupConf(GroupConf c) {
		if (groupconfDAO.groupConfExists(c)) {
            return false;
        } else {
        	groupconfDAO.addGroupConf(c);
            return true;
        }
	}

	@Override
	public void updateGroupConf(GroupConf c) {
		this.groupconfDAO.updateGroupConf(c);
	}

	@Override
	public List<GroupConf> getAll() {
		return this.groupconfDAO.getAll();
	}

	@Override
	public GroupConf getGroupConfById(int id) {
		return this.groupconfDAO.getGroupConfById(id);
	}

	@Override
	public List<GroupConf> getGroupConfByAttr(String attrName, String value) {
		return this.groupconfDAO.getGroupConfByAttr(attrName, value);
	}

	@Override
	public void deleteGroupConf(int id) {
		this.groupconfDAO.deleteGroupConf(id);
		
	}

	public GroupConfDao getCondDAO() {
		return groupconfDAO;
	}

	public void setCondDAO(GroupConfDao condDAO) {
		this.groupconfDAO = condDAO;
	}

}
