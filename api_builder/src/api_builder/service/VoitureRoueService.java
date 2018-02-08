package api_builder.service;
import api_builder.bean.VoitureRoueId;
import api_builder.bean.VoitureRoue;
import java.util.List;
// Generated 8 févr. 2018 16:16:12 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.bean.VoitureRoue
 * @author Hibernate Tools
 */
public interface VoitureRoueService {
    
    public boolean addVoitureRoue(VoitureRoue e);
    public void updateVoitureRoue(VoitureRoue e);
	public List<VoitureRoue> getAll();
    public VoitureRoue getVoitureRoueById(VoitureRoueId id);
    public List<VoitureRoue> getVoitureRoueByAttr(String attrName, String value);
    public void deleteVoitureRoue(VoitureRoue e);
    
}

