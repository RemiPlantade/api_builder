package api_builder.gen.service.impl;
import api_builder.gen.bean.VoitureRoueId;
import api_builder.gen.bean.VoitureRoue;
import api_builder.gen.service.VoitureRoueService;
import api_builder.gen.dao.VoitureRoueDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
@Transactional("tm1")
/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.bean.VoitureRoue
 * @author Hibernate Tools
 */
public class VoitureRoueServiceImpl implements VoitureRoueService {
		@Autowired
		private VoitureRoueDao dao;
    	
	    public void save(VoitureRoue e){
	    	dao.save(e);
	    }
	    
		public List<VoitureRoue> findAll(){
			return (List<VoitureRoue>)  dao.findAll();
		}
		
	    public VoitureRoue findVoitureRoueById(VoitureRoueId id){
	    	return dao.findOne(id);
	    }
	    
	    public List<VoitureRoue> findVoitureRoueByAttr(String attrName, String value){
	    	return dao.findByAttr(attrName,value);
	    }
	    
	    public void delete(VoitureRoueId e){
	    	dao.delete(e);
	    }
    
}

