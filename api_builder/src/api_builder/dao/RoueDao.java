
package api_builder.dao;
import api_builder.bean.Roue;
import java.util.List;
// Generated 8 févr. 2018 16:16:11 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


/**
 * Home object for domain model class Roue.
 * @see api_builder.bean.Roue
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

