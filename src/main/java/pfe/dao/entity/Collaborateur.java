package pfe.dao.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("COLLABORATEUR")
public class Collaborateur extends User implements Serializable {

    @OneToMany(mappedBy = "collaborateur")
    private List<Entretien> entretiens;

    //---------------------------les constructeurs -----------------------

    public Collaborateur() {super();
    }

    public Collaborateur(String nom, String prenom, String email, String login, String password, String photo) {
        super(nom, prenom, email, login, password, photo);
    }

    public Collaborateur(Builder b) {
        b.id=this.getId();
        b.password=this.getPassword();
        b.username=this.getUsername();
        b.email=this.getEmail();
        b.active=this.getActive();
        b.nom=this.getNom();
        b.prenom=this.getPrenom();
        b.photo=this.getPhoto();

    }

    //------------------------ les getters-------------------------------

//    public List<Entretien> getEntretiens() {
//        return entretiens;
//    }


    //------------------------ la classe builder ------------------------

    public class Builder{

        public Long id;
        public String nom;
        public String prenom;
        public String email;
        public String username;
        public String password;
        public boolean active;
        public String photo;


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

        public Collaborateur Build(){
            return new Collaborateur(this);
        }

    }
}
