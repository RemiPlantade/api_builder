package api_builder.gen.api.service;
import api_builder.gen.api.bean.VoitureRoueId;
import api_builder.gen.api.bean.VoitureRoue;
import java.util.List;
// Generated 8 févr. 2018 00:41:34 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.api.bean.VoitureRoue
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

