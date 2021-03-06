package api_builder.app.gen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_builder.app.gen.dao.iface.VoitureDao;
import api_builder.app.gen.model.Voiture;
import api_builder.app.gen.service.iface.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {
	@Autowired
	private VoitureDao voitureDAO;
	
	@Override
	public synchronized boolean addVoiture(Voiture v) {
		if (voitureDAO.voitureExists(v)) {
            return false;
        } else {
        	voitureDAO.addVoiture(v);
            return true;
        }
	}

	@Override
	public void updateVoiture(Voiture v) {
		this.voitureDAO.updateVoiture(v);
	}

	@Override
	public List<Voiture> getAll() {
		return this.voitureDAO.getAll();
	}

	@Override
	public Voiture getVoitureById(int id) {
		return this.voitureDAO.getVoitureById(id);
	}

	@Override
	public List<Voiture> getVoitureByAttr(String attrName, String value) {
		return this.voitureDAO.getVoitureByAttr(attrName, value);
	}

	@Override
	public void deleteVoiture(int id) {
		this.voitureDAO.deleteVoiture(id);
	}

	public VoitureDao getVoitDAO() {
		return voitureDAO;
	}

	public void setVoitDAO(VoitureDao voitDAO) {
		this.voitureDAO = voitDAO;
	}

}
