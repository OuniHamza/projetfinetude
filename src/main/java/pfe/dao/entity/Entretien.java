package pfe.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ENTRETIEN")
public class Entretien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_de_creation")
    private Date dateDeCreation;
    @Column(name = "duree_entretien")
    private String dureeEntretien;
    @ManyToOne
    @JoinColumn(name = "id_recruteur")
    private Recruteur recruteur;
    @OneToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;
    @ManyToOne
    @JoinColumn(name = "id_collaborateur")
    private Collaborateur collaborateur;

    //---------------- les constructeurs ----------------------

    public Entretien() {
    }

    public Entretien(Date dateDeCreation, String dureeEntretien, Candidat candidat, Collaborateur collaborateur) {
        this.dateDeCreation = dateDeCreation;
        this.dureeEntretien = dureeEntretien;
        this.candidat = candidat;
        this.collaborateur = collaborateur;
    }

    public Entretien(Builder b) {
        id=b.id;
        dateDeCreation=b.dateCreation;
        dureeEntretien=b.dureeEntretien;
        candidat=b.candidat;
        collaborateur=b.collaborateur;
        }


    //---------------- LES GETTERS ---------------------------


    public Long getId() {
        return id;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }

    public String getDureeEntretien() {
        return dureeEntretien;
    }

    public Recruteur getRecruteur() {
        return recruteur;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    //------------ LA CLASSE BUILDER -------------------------

    public class Builder{

        public Long id;
        public Date dateCreation;
        public String dureeEntretien;
        public Candidat candidat;
        public Collaborateur collaborateur;



        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder dateCreation(Date dateCreation){
            this.dateCreation=dateCreation;
            return this;
        }
        public Builder dureeEntretien(String dureeEntretien){
            this.dureeEntretien=dureeEntretien;
            return this;
        }
        public Builder candidat(Candidat Candidat){
            this.candidat=Candidat;
            return this;
        }
        public Builder collaborateur(Collaborateur collaborateur){
            this.collaborateur=collaborateur;
            return this;
        }

            public Entretien Build(){
            return new Entretien(this);
        }

    }



}
