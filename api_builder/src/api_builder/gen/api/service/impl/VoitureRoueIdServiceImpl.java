package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.VoitureRoueId;
import api_builder.gen.api.service.VoitureRoueIdService;
import api_builder.gen.api.dao.impl.VoitureRoueIdDaoImpl;
import java.util.List;

// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.gen.api.bean.VoitureRoueId
 * @author Hibernate Tools
 */
public class VoitureRoueIdServiceImpl implements VoitureRoueIdService {

		private VoitureRoueIdDaoImpl dao;
    
    	public VoitureRoueIdServiceImpl(){
    		dao = new VoitureRoueIdDaoImpl();
    	}
    	
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

