package api_builder.gen.api.service.impl;
import api_builder.gen.api.bean.VoitureRoueId;
import api_builder.gen.api.bean.VoitureRoue;
import api_builder.gen.api.service.VoitureRoueService;
import api_builder.gen.api.dao.impl.VoitureRoueDaoImpl;
import java.util.List;

// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.api.bean.VoitureRoue
 * @author Hibernate Tools
 */
public class VoitureRoueServiceImpl implements VoitureRoueService {

		private VoitureRoueDaoImpl dao;
    
    	public VoitureRoueServiceImpl(){
    		dao = new VoitureRoueDaoImpl();
    	}
    	
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

