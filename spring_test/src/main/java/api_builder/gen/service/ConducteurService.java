package api_builder.gen.service;
import api_builder.gen.bean.Conducteur;
import java.util.List;
// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.bean.Conducteur
 * @author Hibernate Tools
 */
public interface ConducteurService {
    
    public void save(Conducteur e);
	public List<Conducteur> findAll();
    public Conducteur findConducteurById(Integer id);
    public List<Conducteur> findConducteurByAttr(String attrName, String value);
    public void delete(Integer e);
   
}

