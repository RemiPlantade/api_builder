package api_builder.service;
import api_builder.bean.Voiture;
import java.util.List;
// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Voiture.
 * @see api_builder.bean.Voiture
 * @author Hibernate Tools
 */
public interface VoitureService {
    
    public boolean addVoiture(Voiture e);
    public void updateVoiture(Voiture e);
	public List<Voiture> getAll();
    public Voiture getVoitureById(Integer id);
    public List<Voiture> getVoitureByAttr(String attrName, String value);
    public void deleteVoiture(Voiture e);
    
}

