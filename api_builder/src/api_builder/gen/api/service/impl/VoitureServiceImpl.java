package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.Voiture;
import api_builder.gen.api.service.VoitureService;
import api_builder.gen.api.dao.impl.VoitureDaoImpl;
import java.util.List;

// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.api.bean.Voiture
 * @author Hibernate Tools
 */
public class VoitureServiceImpl implements VoitureService {

		private VoitureDaoImpl dao;
    
    	public VoitureServiceImpl(){
    		dao = new VoitureDaoImpl();
    	}
    	
	    public boolean addVoiture(Voiture e){
	    	return dao.addVoiture(e);
	    }
	    
	    public void updateVoiture(Voiture e){
	    	dao.updateVoiture(e);
	    }
	    
		public List<Voiture> getAll(){
			List<Voiture> listInstance =  dao.getAll();
			return listInstance;
		}
		
	    public Voiture getVoitureById(Integer id){
	    	Voiture instance = dao.getVoitureById(id);
	    	return instance;
	    }
	    
	    public List<Voiture> getVoitureByAttr(String attrName, String value){
	    	List<Voiture> listInstance = dao.getVoitureByAttr(attrName,value);
	    	return listInstance;
	    }
	    
	    public void deleteVoiture(Voiture e){
	    	dao.deleteVoiture(e);
	    }
    
}

