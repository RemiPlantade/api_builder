package api_builder.gen.api.dao.impl;
import api_builder.gen.api.dao.ConducteurDao;
import api_builder.gen.api.bean.Conducteur;
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
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.api.bean.Conducteur
 * @author Hibernate Tools
 */
public class ConducteurDaoImpl implements ConducteurDao{
    
    @PersistenceContext 
    private EntityManager entityManager;
    
    public boolean addConducteur(Conducteur transientInstance) {
       	try {
           entityManager.persist(transientInstance);
           entityManager.getTransaction().commit();
           return true;
        }
        catch (EntityExistsException re) {
            return false;
        }
    } 
    
        public void updateConducteur(Conducteur detachedInstance) {
        
        try {
            Conducteur result = entityManager.merge(detachedInstance); 
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    
        public void deleteConducteur(Conducteur persistentInstance) {
        try {
            entityManager.remove(persistentInstance);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

        public Conducteur getConducteurById(Integer id) {
        try {
            Conducteur instance = entityManager.find(Conducteur.class, id);
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Conducteur> getAll(){
    
    	try {
            List<Conducteur> instance = entityManager.createQuery(
            "SELECT * FROM  Conducteur").getResultList();
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    public List<Conducteur> getConducteurByAttr(String attrName, String value){
    	
    	try {
        Query query = entityManager.createQuery("SELECT"+attrName+"FROM Conducteur WHERE" + attrName + "= :value");
        query.setParameter("value", value);
        List<Conducteur> instance = (List<Conducteur>) query.getResultList();
        return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    	
    }
    
}

