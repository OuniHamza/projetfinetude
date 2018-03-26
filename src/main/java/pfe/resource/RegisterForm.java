package pfe.resource;

public class RegisterForm {
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String repassword;
    private String email;
    private String photo;
    private String cv;

    public RegisterForm() {
    }

    public RegisterForm(String nom, String prenom, String username, String password, String repassword, String email, String photo, String cv) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
        this.email = email;
        this.photo = photo;
        this.cv = cv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
}
