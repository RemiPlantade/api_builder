package api_builder.app.gen.dao.iface;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import api_builder.app.gen.model.Conducteur;
public interface ConducteurDao {
	public void addConducteur(Conducteur c);
	public void updateConducteur(Conducteur c);
	public List<Conducteur> getAll();
	public Conducteur getConducteurById(int id);
	public List<Conducteur> getConducteurByAttr(String attrName,String value);
	public void deleteConducteur(int id);
	public boolean conducteurExists(Conducteur c);
}
