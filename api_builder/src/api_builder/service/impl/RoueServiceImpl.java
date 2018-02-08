package api_builder.service.impl;
import api_builder.bean.Roue;
import api_builder.service.RoueService;
import api_builder.dao.RoueDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
/**
 * Home object for domain model class Roue.
 * @see api_builder.bean.Roue
 * @author Hibernate Tools
 */
public class RoueServiceImpl implements RoueService {
		@Autowired
		private RoueDao dao;
    	
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

