package api_builder.app.gen.service.iface;

import java.util.List;

import api_builder.app.gen.model.Roue;

public interface RoueService {
	public boolean addRoue(Roue c);
	public void updateRoue(Roue c);
	public List<Roue> getAll();
	public Roue getRoueById(int id);
	public List<Roue> getRoueByAttr(String attrName,String value);
	public void deleteRoue(int id);
}
