package api_builder.gen.api.dao.impl;
import api_builder.gen.api.dao.VoitureDao;
import api_builder.gen.api.bean.Voiture;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityExistsException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Generated 7 févr. 2018 16:17:49 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.api.bean.Voiture
 * @author Hibernate Tools
 */
public class VoitureDaoImpl implements VoitureDao{
    
    @PersistenceContext 
    private EntityManager entityManager;
    
    public boolean addVoiture(Voiture transientInstance) {
       	try {
           entityManager.persist(transientInstance);
           entityManager.getTransaction().commit();
           return true;
        }
        catch (EntityExistsException re) {
            return false;
        }
    } 
    
        public void updateVoiture(Voiture detachedInstance) {
        
        try {
            Voiture result = entityManager.merge(detachedInstance); 
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    
        public void deleteVoiture(Voiture persistentInstance) {
        try {
            entityManager.remove(persistentInstance);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

        public Voiture getVoitureById(Integer id) {
        try {
            Voiture instance = entityManager.find(Voiture.class, id);
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Voiture> getAll(){
    
    	try {
            List<Voiture> instance = entityManager.createQuery(
            "SELECT * FROM  Voiture").getResultList();
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    public List<Voiture> getVoitureByAttr(String attrName, String value){
    	
    	try {
        Query query = entityManager.createQuery("SELECT"+attrName+"FROM Voiture WHERE" + attrName + "= :value");
        query.setParameter("value", value);
        List<Voiture> instance = (List<Voiture>) query.getResultList();
        return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    	
    }
    
}

