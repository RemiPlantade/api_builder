package api_builder.service.impl;
import api_builder.bean.VoitureRoueId;
import api_builder.bean.VoitureRoue;
import api_builder.service.VoitureRoueService;
import api_builder.dao.VoitureRoueDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.bean.VoitureRoue
 * @author Hibernate Tools
 */
public class VoitureRoueServiceImpl implements VoitureRoueService {
		@Autowired
		private VoitureRoueDao dao;
    	
	    public boolean addVoitureRoue(VoitureRoue e){
	    	return dao.addVoitureRoue(e);
	    }
	    
	    public void updateVoitureRoue(VoitureRoue e){
	    	dao.updateVoitureRoue(e);
	    }
	    
		public List<VoitureRoue> getAll(){
			List<VoitureRoue> listInstance =  dao.getAll();
			return listInstance;
		}
		
	    public VoitureRoue getVoitureRoueById(VoitureRoueId id){
	    	VoitureRoue instance = dao.getVoitureRoueById(id);
	    	return instance;
	    }
	    
	    public List<VoitureRoue> getVoitureRoueByAttr(String attrName, String value){
	    	List<VoitureRoue> listInstance = dao.getVoitureRoueByAttr(attrName,value);
	    	return listInstance;
	    }
	    
	    public void deleteVoitureRoue(VoitureRoue e){
	    	dao.deleteVoitureRoue(e);
	    }
    
}

