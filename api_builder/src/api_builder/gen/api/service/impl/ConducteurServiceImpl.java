package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.Conducteur;
import api_builder.gen.api.service.ConducteurService;
import api_builder.gen.api.dao.impl.ConducteurDaoImpl;
import java.util.List;

// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.api.bean.Conducteur
 * @author Hibernate Tools
 */
public class ConducteurServiceImpl implements ConducteurService {

		private ConducteurDaoImpl dao;
    
    	public ConducteurServiceImpl(){
    		dao = new ConducteurDaoImpl();
    	}
    	
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

