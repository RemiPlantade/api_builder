package api_builder.app.gen.dao.iface;

import java.util.List;

import api_builder.app.gen.model.VoitureRoue;
import api_builder.app.gen.model.VoitureRoueId;

public interface VoitureRoueDao {
	public void addVoitureRoue(VoitureRoue c);
	public void updateVoitureRoue(VoitureRoue c);
	public List<VoitureRoue> getAll();
	public VoitureRoue getVoitureRoueById(VoitureRoueId id);
	public List<VoitureRoue> getVoitureRoueByAttr(String attrName,String value);
	public void deleteVoitureRoue(VoitureRoueId id);
	public boolean voitureRoueExists(VoitureRoue c);
}
