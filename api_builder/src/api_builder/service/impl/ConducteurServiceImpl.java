package api_builder.service.impl;
import api_builder.bean.Conducteur;
import api_builder.service.ConducteurService;
import api_builder.dao.ConducteurDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
/**
 * Home object for domain model class Conducteur.
 * @see api_builder.bean.Conducteur
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

