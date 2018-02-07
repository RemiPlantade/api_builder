package api_builder.gen.api.dao.impl;
import api_builder.gen.api.dao.RoueDao;
import api_builder.gen.api.bean.Roue;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityExistsException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Generated 8 févr. 2018 00:41:33 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
/**
 * Home object for domain model class Roue.
 * @see api_builder.gen.api.bean.Roue
 * @author Hibernate Tools
 */
public class RoueDaoImpl implements RoueDao{
    
    @PersistenceContext 
    private EntityManager entityManager;
    
    public boolean addRoue(Roue transientInstance) {
       	try {
           entityManager.persist(transientInstance);
           entityManager.getTransaction().commit();
           return true;
        }
        catch (EntityExistsException re) {
            return false;
        }
    } 
    
        public void updateRoue(Roue detachedInstance) {
        
        try {
            Roue result = entityManager.merge(detachedInstance); 
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    
        public void deleteRoue(Roue persistentInstance) {
        try {
            entityManager.remove(persistentInstance);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

        public Roue getRoueById(Integer id) {
        try {
            Roue instance = entityManager.find(Roue.class, id);
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Roue> getAll(){
    
    	try {
            List<Roue> instance = entityManager.createQuery(
            "SELECT * FROM  Roue").getResultList();
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    public List<Roue> getRoueByAttr(String attrName, String value){
    	
    	try {
        Query query = entityManager.createQuery("SELECT"+attrName+"FROM Roue WHERE" + attrName + "= :value");
        query.setParameter("value", value);
        List<Roue> instance = (List<Roue>) query.getResultList();
        return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    	
    }
    
}

