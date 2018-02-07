
package api_builder.gen.api.dao;
import api_builder.gen.api.bean.VoitureRoueId;
import java.util.List;
// Generated 8 févr. 2018 00:41:33 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.gen.api.bean.VoitureRoueId
 * @author Hibernate Tools
 */
public interface VoitureRoueIdDao {

	public boolean addVoitureRoueId(VoitureRoueId e);
	public void updateVoitureRoueId(VoitureRoueId e);
	public List<VoitureRoueId> getAll();
    public VoitureRoueId getVoitureRoueIdById(int id);
    public List<VoitureRoueId> getVoitureRoueIdByAttr(String attrName, String value);
    public void deleteVoitureRoueId(VoitureRoueId e);
}

