package pfe.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("CANDIADT")
public class Candidat extends User implements Serializable {

    @Column(name = "cv")
    private  String  cv;
    @ManyToOne
    @JoinColumn(name = "id_Recruteur")
    private Recruteur recruteur;
    @ManyToMany
    @JoinTable(name="candidat_offre",
            joinColumns=
            @JoinColumn(name="id_Candidat", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="id_Offre", referencedColumnName="id")
    )
    private List<Offre> offres;

//----------------------les constructeurs-----------------------------


    public Candidat() { super();
    }

    public Candidat( String nom, String prenom, String email, String login, String password, String photo, String cv) {
        super(nom, prenom, email, login, password, photo);
        this.cv = cv;
    }

    public Candidat(Builder b) {

        this.setEmail(b.email);
        this.setPrenom(b.prenom);
        this.setRole(b.role);
        this.setNom(b.nom);
        this.setPassword(b.password);
       // this.setRepassword(b.repassword);
        this.setId(b.id);
        this.setActived(b.active);
        this.setUsername(b.username);
        this.setPhoto(b.photo);
        cv=b.cv;

    }



    //------------------les getters ---------------------------------


    public String getCv() {
        return cv;
    }

    @JsonIgnore
    public Recruteur getRecruteur() {
        return recruteur;
    }

    public List<Offre> getOffres() {
        return offres;
    }


    //----------------- la classe builder ----------------------------

    public static class Builder{

        public Long id;
        public Role role;
        public String nom;
        public String prenom;
        public String email;
        public String username;
        public String password;
       // public String repassword;
        public String cv;
        public String photo;
        public boolean active;


        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder nom(String nom){
            this.nom=nom;
            return this;
        }
        public Builder role(Role role){
            this.role=role;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder username(String username){
            this.username=username;
            return this;
        }
        public Builder password(String password){
            this.password=password;
            return this;
        }
//        public Builder repassword(String repassword){
//            this.repassword=repassword;
//            return this;
//        }
        public Builder prenom(String prenom){
            this.prenom=prenom;
            return this;
        }
        public Builder active(boolean active){
            this.active=active;
            return this;
        }
        public Builder cv(String cv){
            this.cv=cv;
            return this;
        }
        public Builder photo(String photo){
            this.photo=photo;
            return this;
        }

        public Candidat Build(){
            return new Candidat(this);
        }

    }

}
