package api_builder.gen.service;
import api_builder.gen.bean.Voiture;
import java.util.List;
// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.bean.Voiture
 * @author Hibernate Tools
 */
public interface VoitureService {
    
    public void save(Voiture e);
	public List<Voiture> findAll();
    public Voiture findVoitureById(Integer id);
    public List<Voiture> findVoitureByAttr(String attrName, String value);
    public void delete(Integer e);
   
}

