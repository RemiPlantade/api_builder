package api_builder.gen.service.impl;
import api_builder.gen.bean.Conducteur;
import api_builder.gen.service.ConducteurService;
import api_builder.gen.dao.ConducteurDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
@Transactional("tm1")
/**
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.bean.Conducteur
 * @author Hibernate Tools
 */
public class ConducteurServiceImpl implements ConducteurService {
		@Autowired
		private ConducteurDao dao;
    	
	    public void save(Conducteur e){
	    	dao.save(e);
	    }
	    
		public List<Conducteur> findAll(){
			return (List<Conducteur>)  dao.findAll();
		}
		
	    public Conducteur findConducteurById(Integer id){
	    	return dao.findOne(id);
	    }
	    
	    public List<Conducteur> findConducteurByAttr(String attrName, String value){
	    	return dao.findByAttr(attrName,value);
	    }
	    
	    public void delete(Integer e){
	    	dao.delete(e);
	    }
    
}

