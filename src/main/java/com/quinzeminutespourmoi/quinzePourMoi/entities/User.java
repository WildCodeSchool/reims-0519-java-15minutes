
@Entity
public class User {

    public User() {
    }

    public User(String username, String password, String mail, String role){
        this.setUsername = username;
        this.setPassword = password;
        this.setMail = mail;
        this.setRole = role;
    }

    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String role;

    public Long getId() {
        return id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}