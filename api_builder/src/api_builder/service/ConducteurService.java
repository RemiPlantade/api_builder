package api_builder.service;
import api_builder.bean.Conducteur;
import java.util.List;
// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Conducteur.
 * @see api_builder.bean.Conducteur
 * @author Hibernate Tools
 */
public interface ConducteurService {
    
    public boolean addConducteur(Conducteur e);
    public void updateConducteur(Conducteur e);
	public List<Conducteur> getAll();
    public Conducteur getConducteurById(Integer id);
    public List<Conducteur> getConducteurByAttr(String attrName, String value);
    public void deleteConducteur(Conducteur e);
    
}

