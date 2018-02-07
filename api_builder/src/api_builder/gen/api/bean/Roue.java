package api_builder.gen.api.bean;
// Generated 8 f�vr. 2018 00:41:31 by Hibernate Tools 6.0.0-SNAPSHOT

import api_builder.gen.jackson.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Roue generated by hbm2java
 */
@Entity
@Table(name="roue"
)
public class Roue  implements java.io.Serializable {


     private Integer idroue;
     private Long rayon;
     private Double largeur;
     private Set<VoitureRoue> voitureRoues = new HashSet<VoitureRoue>(0);

    public Roue() {
    }

    public Roue(Long rayon, Double largeur, Set<VoitureRoue> voitureRoues) {
       this.rayon = rayon;
       this.largeur = largeur;
       this.voitureRoues = voitureRoues;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idroue", unique=true, nullable=false)
    @JsonView(Views.RoueView.class)
    public Integer getIdroue() {
        return this.idroue;
    }
    
    public void setIdroue(Integer idroue) {
        this.idroue = idroue;
    }

    
    @Column(name="rayon", precision=10, scale=0)
    @JsonView(Views.RoueView.class)
    public Long getRayon() {
        return this.rayon;
    }
    
    public void setRayon(Long rayon) {
        this.rayon = rayon;
    }

    
    @Column(name="largeur", precision=22, scale=0)
    @JsonView(Views.RoueView.class)
    public Double getLargeur() {
        return this.largeur;
    }
    
    public void setLargeur(Double largeur) {
        this.largeur = largeur;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="roue")
    @JsonView(Views.RoueView.class)
    public Set<VoitureRoue> getVoitureRoues() {
        return this.voitureRoues;
    }
    
    public void setVoitureRoues(Set<VoitureRoue> voitureRoues) {
        this.voitureRoues = voitureRoues;
    }




}


