package api_builder.gen.service;
import api_builder.gen.bean.VoitureRoueId;
import api_builder.gen.bean.VoitureRoue;
import java.util.List;
// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.bean.VoitureRoue
 * @author Hibernate Tools
 */
public interface VoitureRoueService {
    
    public void save(VoitureRoue e);
	public List<VoitureRoue> findAll();
    public VoitureRoue findVoitureRoueById(VoitureRoueId id);
    public List<VoitureRoue> findVoitureRoueByAttr(String attrName, String value);
    public void delete(VoitureRoueId e);
   
}

