package api_builder.app.gen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_builder.app.gen.dao.iface.RoueDao;
import api_builder.app.gen.model.Roue;
import api_builder.app.gen.service.iface.RoueService;

@Service
public class RoueServiceImpl implements RoueService{
	@Autowired
	private RoueDao roueDAO;
	
	@Override
	public synchronized boolean addRoue(Roue c) {
		if (roueDAO.roueExists(c)) {
            return false;
        } else {
        	roueDAO.addRoue(c);
            return true;
        }
	}

	@Override
	public void updateRoue(Roue c) {
		this.roueDAO.updateRoue(c);
	}

	@Override
	public List<Roue> getAll() {
		return this.roueDAO.getAll();
	}

	@Override
	public Roue getRoueById(int id) {
		return this.roueDAO.getRoueById(id);
	}

	@Override
	public List<Roue> getRoueByAttr(String attrName, String value) {
		return this.roueDAO.getRoueByAttr(attrName, value);
	}

	@Override
	public void deleteRoue(int id) {
		this.roueDAO.deleteRoue(id);
		
	}

	public RoueDao getRoueDAO() {
		return roueDAO;
	}

	public void setRoueDAO(RoueDao condDAO) {
		this.roueDAO = condDAO;
	}

}
