package pfe.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Collection<User> users;
    //------------constructeurs-----------------------

    public Role( String roleName, Collection<User> users) {
        this.roleName = roleName;
        this.users = users;
    }

    public Role() {

    }
    public Role(Builder b){
        roleName=b.roleName;

    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    @JsonIgnore
    public Collection<User> getUsers() {
        return users;
    }
    //--------------- classe builder --------------------------

    public static class Builder{


        public String roleName;


        public Builder roleName(String roleName){
            this.roleName=roleName;
            return this;
        }


        public Role Build(){
            return new Role(this);
        }

        }
}


