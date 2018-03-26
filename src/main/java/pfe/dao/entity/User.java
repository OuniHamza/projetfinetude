package pfe.dao.entity;

import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorOptions(force=true)
@Table(name = "users")
public  class  User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email" )
    @Email
    private String email;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;
//    @Column(name = "repassword")
//    private String repassword;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "photo")
    private String  photo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private Role role;

    //----------les constructeur----------------------------------


    public User() {
    }

    public User( String nom, String prenom, String email, String username, String password,String photo) {
        this.lastname = nom;
        this.firstname = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
        this.photo=photo;
      // this.repassword=repassword;

    }


    //---------les getters----------------------------------------


//    public String getRepassword() {
//        return repassword;
//    }

//    public void setRepassword(String repassword) {
//        this.repassword = repassword;
//    }

    public String getNom() {
        return firstname;
    }

    public String getPrenom() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNom(String nom) {
        this.firstname = nom;
    }

    public void setPrenom(String prenom) {
        this.lastname = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setActived(Boolean active) {
        this.active = active;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}