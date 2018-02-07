package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.VoitureRoueId;
import api_builder.gen.api.service.VoitureRoueIdService;
import api_builder.gen.api.dao.VoitureRoueIdDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Generated 7 févr. 2018 16:17:49 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



@Service
/**
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.gen.api.bean.VoitureRoueId
 * @author Hibernate Tools
 */
public class VoitureRoueIdServiceImpl implements VoitureRoueIdService {
		@Autowired
		private VoitureRoueIdDao dao;
    	
	    public boolean addVoitureRoueId(VoitureRoueId e){
	    	return dao.addVoitureRoueId(e);
	    }
	    
	    public void updateVoitureRoueId(VoitureRoueId e){
	    	dao.updateVoitureRoueId(e);
	    }
	    
		public List<VoitureRoueId> getAll(){
			List<VoitureRoueId> listInstance =  dao.getAll();
			return listInstance;
		}
		
	    public VoitureRoueId getVoitureRoueIdById(int id){
	    	VoitureRoueId instance = dao.getVoitureRoueIdById(id);
	    	return instance;
	    }
	    
	    public List<VoitureRoueId> getVoitureRoueIdByAttr(String attrName, String value){
	    	List<VoitureRoueId> listInstance = dao.getVoitureRoueIdByAttr(attrName,value);
	    	return listInstance;
	    }
	    
	    public void deleteVoitureRoueId(VoitureRoueId e){
	    	dao.deleteVoitureRoueId(e);
	    }
    
}

