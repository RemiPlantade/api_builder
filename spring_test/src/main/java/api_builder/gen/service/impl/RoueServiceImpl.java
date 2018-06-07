package api_builder.gen.service.impl;
import api_builder.gen.bean.Roue;
import api_builder.gen.service.RoueService;
import api_builder.gen.dao.RoueDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
@Transactional("tm1")
/**
 * Home object for domain model class Roue.
 * @see api_builder.gen.bean.Roue
 * @author Hibernate Tools
 */
public class RoueServiceImpl implements RoueService {
		@Autowired
		private RoueDao dao;
    	
	    public void save(Roue e){
	    	dao.save(e);
	    }
	    
		public List<Roue> findAll(){
			return (List<Roue>)  dao.findAll();
		}
		
	    public Roue findRoueById(Integer id){
	    	return dao.findOne(id);
	    }
	    
	    public List<Roue> findRoueByAttr(String attrName, String value){
	    	return dao.findByAttr(attrName,value);
	    }
	    
	    public void delete(Integer e){
	    	dao.delete(e);
	    }
    
}

