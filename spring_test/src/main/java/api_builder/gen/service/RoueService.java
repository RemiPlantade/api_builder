package api_builder.gen.service;
import api_builder.gen.bean.Roue;
import java.util.List;
// Generated 16 mars 2018 15:14:25 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Roue.
 * @see api_builder.gen.bean.Roue
 * @author Hibernate Tools
 */
public interface RoueService {
    
    public void save(Roue e);
	public List<Roue> findAll();
    public Roue findRoueById(Integer id);
    public List<Roue> findRoueByAttr(String attrName, String value);
    public void delete(Integer e);
   
}

