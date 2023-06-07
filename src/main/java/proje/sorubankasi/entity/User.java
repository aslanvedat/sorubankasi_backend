package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import proje.sorubankasi.dto.request.UserRequestDTO;

import java.util.Collection;

@Data
@Entity
@Table(name = "users")
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
    @ManyToMany(cascade = CascadeType.ALL
    )
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    public User() {

    }

    public User(UserRequestDTO userRequestDTO) {
        this.name = userRequestDTO.getName();
        this.mail = userRequestDTO.getMail();
        this.password = new BCryptPasswordEncoder().encode(userRequestDTO.getPassword());
    }

}
