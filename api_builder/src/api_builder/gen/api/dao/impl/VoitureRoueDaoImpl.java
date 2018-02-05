package api_builder.gen.api.dao.impl;
import api_builder.gen.api.bean.VoitureRoueId;
import api_builder.gen.api.dao.VoitureRoueDao;
import api_builder.gen.api.bean.VoitureRoue;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityExistsException;
// Generated 5 févr. 2018 14:01:45 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.api.bean.VoitureRoue
 * @author Hibernate Tools
 */
public class VoitureRoueDaoImpl implements VoitureRoueDao{
    
    @PersistenceContext private EntityManager entityManager;
    
        public boolean addVoitureRoue(VoitureRoue transientInstance) {
        
        try {
            entityManager.persist(transientInstance);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (EntityExistsException re) {
            return false;
        }
    } 
    
        public void updateVoitureRoue(VoitureRoue detachedInstance) {
        
        try {
            VoitureRoue result = entityManager.merge(detachedInstance); 
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    
        public void deleteVoitureRoue(VoitureRoue persistentInstance) {
        try {
            entityManager.remove(persistentInstance);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

        public VoitureRoue getVoitureRoueById(VoitureRoueId id) {
        try {
            VoitureRoue instance = entityManager.find(VoitureRoue.class, id);
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List<VoitureRoue> getAll(){
    
    	try {
            List<VoitureRoue> instance = entityManager.createQuery(
            "SELECT * FROM  VoitureRoue").getResultList();
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    public List<VoitureRoue> getVoitureRoueByAttr(String attrName, String value){
    	
    	try {
        Query query = entityManager.createQuery("SELECT"+attrName+"FROM VoitureRoue WHERE" + attrName + "= :value");
        query.setParameter("value", value);
        List<VoitureRoue> instance = (List<VoitureRoue>) query.getResultList();
        return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    	
    }
    
}

