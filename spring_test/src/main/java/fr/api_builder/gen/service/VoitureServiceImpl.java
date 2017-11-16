package fr.api_builder.gen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.api_builder.gen.dao.iface.VoitureDAO;
import fr.api_builder.gen.model.Voiture;
import fr.api_builder.gen.service.iface.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {
	@Autowired
	private VoitureDAO voitureDAO;
	
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

	public VoitureDAO getVoitDAO() {
		return voitureDAO;
	}

	public void setVoitDAO(VoitureDAO voitDAO) {
		this.voitureDAO = voitDAO;
	}

}
