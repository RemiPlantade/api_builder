package api_builder.app.gen.service.iface;

import java.util.List;

import api_builder.app.gen.model.Conducteur;

public interface ConducteurService {
	public boolean addConducteur(Conducteur c);
	public void updateConducteur(Conducteur c);
	public List<Conducteur> getAll();
	public Conducteur getConducteurById(int id);
	public List<Conducteur> getConducteurByAttr(String attrName,String value);
	public void deleteConducteur(int id);
}
