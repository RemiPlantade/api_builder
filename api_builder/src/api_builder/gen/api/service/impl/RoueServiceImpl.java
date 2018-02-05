package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.Roue;
import api_builder.gen.api.service.RoueService;
import api_builder.gen.api.dao.impl.RoueDaoImpl;
import java.util.List;

// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Roue.
 * @see api_builder.gen.api.bean.Roue
 * @author Hibernate Tools
 */
public class RoueServiceImpl implements RoueService {

		private RoueDaoImpl dao;
    
    	public RoueServiceImpl(){
    		dao = new RoueDaoImpl();
    	}
    	
	    public boolean addRoue(Roue e){
	    	return dao.addRoue(e);
	    }
	    
	    public void updateRoue(Roue e){
	    	dao.updateRoue(e);
	    }
	    
		public List<Roue> getAll(){
			List<Roue> listInstance =  dao.getAll();
			return listInstance;
		}
		
	    public Roue getRoueById(Integer id){
	    	Roue instance = dao.getRoueById(id);
	    	return instance;
	    }
	    
	    public List<Roue> getRoueByAttr(String attrName, String value){
	    	List<Roue> listInstance = dao.getRoueByAttr(attrName,value);
	    	return listInstance;
	    }
	    
	    public void deleteRoue(Roue e){
	    	dao.deleteRoue(e);
	    }
    
}

