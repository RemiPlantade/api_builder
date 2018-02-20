package api_builder.app.conf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_builder.app.conf.dao.GroupPermissionConfDao;
import api_builder.app.conf.model.GroupPermissionConf;
import api_builder.app.conf.service.GroupPermissionConfService;

@Service
public class GroupPermissionConfServiceImpl implements GroupPermissionConfService{
	
	@Autowired
	private GroupPermissionConfDao grouppermissionconfDAO;
	
	@Override
	public synchronized boolean addGroupPermissionConf(GroupPermissionConf c) {
		if (grouppermissionconfDAO.groupPermissionConfExists(c)) {
            return false;
        } else {
        	grouppermissionconfDAO.addGroupPermissionConf(c);
            return true;
        }
	}

	@Override
	public void updateGroupPermissionConf(GroupPermissionConf c) {
		this.grouppermissionconfDAO.updateGroupPermissionConf(c);
	}

	@Override
	public List<GroupPermissionConf> getAll() {
		return this.grouppermissionconfDAO.getAll();
	}

	@Override
	public GroupPermissionConf getGroupPermissionConfById(int id) {
		return this.grouppermissionconfDAO.getGroupPermissionConfById(id);
	}

	@Override
	public List<GroupPermissionConf> getGroupPermissionConfByAttr(String attrName, String value) {
		return this.grouppermissionconfDAO.getGroupPermissionConfByAttr(attrName, value);
	}

	@Override
	public void deleteGroupPermissionConf(int id) {
		this.grouppermissionconfDAO.deleteGroupPermissionConf(id);
		
	}

	public GroupPermissionConfDao getCondDAO() {
		return grouppermissionconfDAO;
	}

	public void setCondDAO(GroupPermissionConfDao condDAO) {
		this.grouppermissionconfDAO = condDAO;
	}

}
