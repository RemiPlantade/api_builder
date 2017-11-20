package fr.api_builder.gen.model;
// Generated 20 nov. 2017 11:07:17 by Hibernate Tools 5.2.6.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VoitureRoueId generated by hbm2java
 */
@Embeddable
public class VoitureRoueId  implements java.io.Serializable {


     private int idVoiture;
     private int idRoue;

    public VoitureRoueId() {
    }

    public VoitureRoueId(int idVoiture, int idRoue) {
       this.idVoiture = idVoiture;
       this.idRoue = idRoue;
    }
   


    @Column(name="id_voiture", nullable=false)
    public int getIdVoiture() {
        return this.idVoiture;
    }
    
    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }


    @Column(name="id_roue", nullable=false)
    public int getIdRoue() {
        return this.idRoue;
    }
    
    public void setIdRoue(int idRoue) {
        this.idRoue = idRoue;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VoitureRoueId) ) return false;
		 VoitureRoueId castOther = ( VoitureRoueId ) other; 
         
		 return (this.getIdVoiture()==castOther.getIdVoiture())
 && (this.getIdRoue()==castOther.getIdRoue());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdVoiture();
         result = 37 * result + this.getIdRoue();
         return result;
   }   


}


