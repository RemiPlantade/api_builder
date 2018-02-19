package api_builder.app.gen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import api_builder.app.gen.dao.iface.ConducteurDao;
import api_builder.app.gen.model.Conducteur;
import api_builder.app.gen.service.iface.ConducteurService;

@Service
public class ConducteurServiceImpl implements ConducteurService{
	
	@Autowired
	private ConducteurDao conducteurDAO;
	
	@Override
	public synchronized boolean addConducteur(Conducteur c) {
		if (conducteurDAO.conducteurExists(c)) {
            return false;
        } else {
        	conducteurDAO.addConducteur(c);
            return true;
        }
	}

	@Override
	public void updateConducteur(Conducteur c) {
		this.conducteurDAO.updateConducteur(c);
	}

	@Override
	public List<Conducteur> getAll() {
		return this.conducteurDAO.getAll();
	}

	@Override
	public Conducteur getConducteurById(int id) {
		return this.conducteurDAO.getConducteurById(id);
	}

	@Override
	public List<Conducteur> getConducteurByAttr(String attrName, String value) {
		return this.conducteurDAO.getConducteurByAttr(attrName, value);
	}

	@Override
	public void deleteConducteur(int id) {
		this.conducteurDAO.deleteConducteur(id);
		
	}

	public ConducteurDao getCondDAO() {
		return conducteurDAO;
	}

	public void setCondDAO(ConducteurDao condDAO) {
		this.conducteurDAO = condDAO;
	}

}
