
package api_builder.gen.api.dao;
import api_builder.gen.api.bean.Roue;
import java.util.List;
// Generated 7 f�vr. 2018 16:17:48 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class Roue.
 * @see api_builder.gen.api.bean.Roue
 * @author Hibernate Tools
 */
public interface RoueDao {

	public boolean addRoue(Roue e);
	public void updateRoue(Roue e);
	public List<Roue> getAll();
    public Roue getRoueById(Integer id);
    public List<Roue> getRoueByAttr(String attrName, String value);
    public void deleteRoue(Roue e);
}

