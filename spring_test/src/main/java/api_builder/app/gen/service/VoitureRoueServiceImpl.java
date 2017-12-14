package api_builder.app.gen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_builder.app.gen.dao.iface.VoitureRoueDao;
import api_builder.app.gen.model.VoitureRoue;
import api_builder.app.gen.model.VoitureRoueId;
import api_builder.app.gen.service.iface.VoitureRoueService;

@Service
public class VoitureRoueServiceImpl implements VoitureRoueService {
	@Autowired
	private VoitureRoueDao voitureRoueDAO;
	
	@Override
	public synchronized boolean addVoitureRoue(VoitureRoue v) {
		if (voitureRoueDAO.voitureRoueExists(v)) {
            return false;
        } else {
        	voitureRoueDAO.addVoitureRoue(v);
            return true;
        }
	}

	@Override
	public void updateVoitureRoue(VoitureRoue v) {
		this.voitureRoueDAO.updateVoitureRoue(v);
	}

	@Override
	public List<VoitureRoue> getAll() {
		return this.voitureRoueDAO.getAll();
	}

	@Override
	public VoitureRoue getVoitureRoueById(VoitureRoueId id) {
		return this.voitureRoueDAO.getVoitureRoueById(id);
	}

	@Override
	public List<VoitureRoue> getVoitureRoueByAttr(String attrName, String value) {
		return this.voitureRoueDAO.getVoitureRoueByAttr(attrName, value);
	}

	@Override
	public void deleteVoitureRoue(VoitureRoueId id) {
		this.voitureRoueDAO.deleteVoitureRoue(id);
	}

	public VoitureRoueDao getVoitDAO() {
		return voitureRoueDAO;
	}

	public void setVoitDAO(VoitureRoueDao voitDAO) {
		this.voitureRoueDAO = voitDAO;
	}

}
