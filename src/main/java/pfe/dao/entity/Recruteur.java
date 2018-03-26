package pfe.dao.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("RECRUTEUR")
public class Recruteur extends User implements Serializable {


    @OneToMany(mappedBy = "recruteur")
    private List<Offre> offres;
    @OneToMany(mappedBy = "recruteur")
    private List<Candidat> candidats;
    @OneToMany(mappedBy = "recruteur")
    private List<Entretien> entretiens;
    //--------- les getters------------------------------------------------

    public List<Offre> getOffres() {
        return offres;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public List<Entretien> getEntretiens() {
        return entretiens;
    }

    //---------les constructeurs-------------------------------------------

    public Recruteur() {
        super();
    }

    public Recruteur( String nom, String prenom, String email, String username, String password, String photo) {
        super(nom, prenom, email, username, password, photo);
        }

    public Recruteur(Builder b) {
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


    }
//
    //--------------la class builder--------------------------------------

    public static class Builder{

        public Long id;
        public String nom;
        public String prenom;
        public String email;
        public String username;
        public String password;
        public String repassword;
        public Role role;
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
        public Builder prenom(String prenom){
            this.prenom=prenom;
            return this;
        }
        public Builder active(boolean active){
            this.active=active;
            return this;
        }
        public Builder photo(String photo){
            this.photo=photo;
            return this;
        }
        public  Builder role(Role role){
            this.role=role;
            return this;
        }



        public Recruteur Build(){
            return new Recruteur(this);
        }

    }





}
