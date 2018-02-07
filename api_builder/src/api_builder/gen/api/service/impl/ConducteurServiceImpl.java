package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.Conducteur;
import api_builder.gen.api.service.ConducteurService;
import api_builder.gen.api.dao.ConducteurDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Generated 7 févr. 2018 16:17:49 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
/**
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.api.bean.Conducteur
 * @author Hibernate Tools
 */
public class ConducteurServiceImpl implements ConducteurService {
		@Autowired
		private ConducteurDao dao;
    	
	    public boolean addConducteur(Conducteur e){
	    	return dao.addConducteur(e);
	    }
	    
	    public void updateConducteur(Conducteur e){
	    	dao.updateConducteur(e);
	    }
	    
		public List<Conducteur> getAll(){
			List<Conducteur> listInstance =  dao.getAll();
			return listInstance;
		}
		
	    public Conducteur getConducteurById(Integer id){
	    	Conducteur instance = dao.getConducteurById(id);
	    	return instance;
	    }
	    
	    public List<Conducteur> getConducteurByAttr(String attrName, String value){
	    	List<Conducteur> listInstance = dao.getConducteurByAttr(attrName,value);
	    	return listInstance;
	    }
	    
	    public void deleteConducteur(Conducteur e){
	    	dao.deleteConducteur(e);
	    }
    
}

