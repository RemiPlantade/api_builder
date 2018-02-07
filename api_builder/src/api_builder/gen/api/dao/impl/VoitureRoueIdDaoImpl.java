package api_builder.gen.api.dao.impl;
import api_builder.gen.api.dao.VoitureRoueIdDao;
import api_builder.gen.api.bean.VoitureRoueId;
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
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.gen.api.bean.VoitureRoueId
 * @author Hibernate Tools
 */
public class VoitureRoueIdDaoImpl implements VoitureRoueIdDao{
    
    @PersistenceContext 
    private EntityManager entityManager;
    
    public boolean addVoitureRoueId(VoitureRoueId transientInstance) {
       	try {
           entityManager.persist(transientInstance);
           entityManager.getTransaction().commit();
           return true;
        }
        catch (EntityExistsException re) {
            return false;
        }
    } 
    
        public void updateVoitureRoueId(VoitureRoueId detachedInstance) {
        
        try {
            VoitureRoueId result = entityManager.merge(detachedInstance); 
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    
        public void deleteVoitureRoueId(VoitureRoueId persistentInstance) {
        try {
            entityManager.remove(persistentInstance);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

        public VoitureRoueId getVoitureRoueIdById(int id) {
        try {
            VoitureRoueId instance = entityManager.find(VoitureRoueId.class, id);
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List<VoitureRoueId> getAll(){
    
    	try {
            List<VoitureRoueId> instance = entityManager.createQuery(
            "SELECT * FROM  VoitureRoueId").getResultList();
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    
    public List<VoitureRoueId> getVoitureRoueIdByAttr(String attrName, String value){
    	
    	try {
        Query query = entityManager.createQuery("SELECT"+attrName+"FROM VoitureRoueId WHERE" + attrName + "= :value");
        query.setParameter("value", value);
        List<VoitureRoueId> instance = (List<VoitureRoueId>) query.getResultList();
        return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    	
    }
    
}

