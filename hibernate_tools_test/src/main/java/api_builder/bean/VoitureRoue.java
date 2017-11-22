package api_builder.bean;
// Generated 22 nov. 2017 12:32:22 by Hibernate Tools 5.2.6.Final
// Custom

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import api_builder.app.jackson.Views;
import com.fasterxml.jackson.annotation.JsonView;
/**
 * VoitureRoue generated by hbm2java
 */
@Entity
@Table(name="voiture_roue"

)
public class VoitureRoue  implements java.io.Serializable {


     private VoitureRoueId id;
     private Roue roue;
     private Voiture voiture;

    public VoitureRoue() {
    }

    public VoitureRoue(VoitureRoueId id, Roue roue, Voiture voiture) {
       this.id = id;
       this.roue = roue;
       this.voiture = voiture;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idVoiture", column=@Column(name="id_voiture", nullable=false) ), 
        @AttributeOverride(name="idRoue", column=@Column(name="id_roue", nullable=false) ) } )
    
    public VoitureRoueId getId() {
        return this.id;
    }
    
    public void setId(VoitureRoueId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_roue", nullable=false, insertable=false, updatable=false)
    @JsonView(Views.Public.class)
    public Roue getRoue() {
        return this.roue;
    }
    
    public void setRoue(Roue roue) {
        this.roue = roue;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_voiture", nullable=false, insertable=false, updatable=false)
    @JsonView(Views.Public.class)
    public Voiture getVoiture() {
        return this.voiture;
    }
    
    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }




}


