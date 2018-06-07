package api_builder.gen.service.impl;
import api_builder.gen.bean.Voiture;
import api_builder.gen.service.VoitureService;
import api_builder.gen.dao.VoitureDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
@Transactional("tm1")
/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.bean.Voiture
 * @author Hibernate Tools
 */
public class VoitureServiceImpl implements VoitureService {
		@Autowired
		private VoitureDao dao;
    	
	    public void save(Voiture e){
	    	dao.save(e);
	    }
	    
		public List<Voiture> findAll(){
			return (List<Voiture>)  dao.findAll();
		}
		
	    public Voiture findVoitureById(Integer id){
	    	return dao.findOne(id);
	    }
	    
	    public List<Voiture> findVoitureByAttr(String attrName, String value){
	    	return dao.findByAttr(attrName,value);
	    }
	    
	    public void delete(Integer e){
	    	dao.delete(e);
	    }
    
}

