package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.Voiture;
import api_builder.gen.api.service.VoitureService;
import api_builder.gen.api.dao.VoitureDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Generated 7 févr. 2018 16:17:49 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.api.bean.Voiture
 * @author Hibernate Tools
 */
public class VoitureServiceImpl implements VoitureService {
		@Autowired
		private VoitureDao dao;
    	
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

