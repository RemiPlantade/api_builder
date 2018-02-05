
package api_builder.gen.api.dao;
import api_builder.gen.api.bean.Conducteur;
import java.util.List;
// Generated 5 févr. 2018 14:01:44 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.api.bean.Conducteur
 * @author Hibernate Tools
 */
public interface ConducteurDao {

	public boolean addConducteur(Conducteur e);
	public void updateConducteur(Conducteur e);
	public List<Conducteur> getAll();
    public Conducteur getConducteurById(Integer id);
    public List<Conducteur> getConducteurByAttr(String attrName, String value);
    public void deleteConducteur(Conducteur e);
}

