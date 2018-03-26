package pfe.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "OFFRE")
public class Offre implements Serializable {

    //-------- les attributs ---------------------------------

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title" )
    private String title;
//    @Column(name ="missions")
//    private String missions;
    @Column(name = "description")
    private String description;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "experience")
    private String experience;
    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "RECRUTEUR_ID")
    private Recruteur recruteur;
    @ManyToMany(mappedBy = "offres")
    private List<Candidat> candidats;

    //--------------- les constructeurs -----------------------

    public Offre() {
    }

    public Offre( String titre, double salary, String qualificationRequises, String description,String experience) {
        this.title = titre;
        this.description = description;
        this.qualification = qualificationRequises;
        this.salary = salary;
        this.experience=experience;

    }

    public Offre(Builder b) {
        id=b.id;
        title=b.titre;
        description=b.description;
        recruteur=b.recruteur;
        salary=b.salary;
        qualification=b.qualification;
        experience=b.experience;
    }

    //----------- les getters ---------------------------------


    @JsonIgnore
    public Recruteur getRecruteur() {
        return recruteur;
    }

//    public List<Candidat> getCandidats() {
//        return candidats;
//    }


    public void setId(Long id) {
        this.id = id;
    }

   public void setTitle(String title) {
        this.title = title;
    }



    public void setQualification(String qualificationRequises) {
        this.qualification = qualificationRequises;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecruteur(Recruteur recruteur) {
        this.recruteur = recruteur;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getExperience() {

        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public String getQualification() {
        return qualification;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //------------- la classe builder ------------------------

    public static class Builder{

        public Long id;
        public String titre;
        public String description;
        public String qualification;
        public Recruteur recruteur;
        public double salary;
        public String experience;


        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder title(String titre){
            this.titre=titre;
            return this;
        }
        public Builder salary(double salary){
            this.salary=salary;
            return this;
        }
        public Builder description(String description){
            this.description=description;
            return this;
        }
        public Builder experience(String experience){
            this.experience=experience;
            return this;
        }

        public Builder qualification(String qualification){
            this.qualification=qualification;
            return this;
        }
        public Builder recruteur(Recruteur recruteur){
            this.recruteur=recruteur;
            return this;
        }

        public Offre Build(){
            return new Offre(this);
        }

    }
}
