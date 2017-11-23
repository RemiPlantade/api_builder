package api_builder.app.gen.service.iface;

import java.util.List;

import api_builder.app.gen.model.Voiture;

public interface VoitureService {
	public boolean addVoiture(Voiture c);
	public void updateVoiture(Voiture c);
	public List<Voiture> getAll();
	public Voiture getVoitureById(int id);
	public List<Voiture> getVoitureByAttr(String attrName,String value);
	public void deleteVoiture(int id);
}
