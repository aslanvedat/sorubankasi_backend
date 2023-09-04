package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import proje.sorubankasi.dto.request.UserRequestDTO;

import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.LinkedList;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "userName") // ad soyad
    private String name;

    @Column(name = "userMail")
    private String mail;

    @Column(name = "password")
    private String password;




    //roller(collection??
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new LinkedList<>();


    public User() {

    }

    public User(UserRequestDTO userRequestDTO) {
        this.name = userRequestDTO.getName();
        this.mail = userRequestDTO.getMail();
        this.password = new BCryptPasswordEncoder().encode(userRequestDTO.getPassword());
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public void addRole(Role role) {
        if (role == null) {
            throw new InvalidParameterException("Role cannot be null!");
        }
        roles.add(role);
    }

}
