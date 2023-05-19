package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "kullanici")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private long id;

@Column(name = "userName")
private String name;
@Column(name = "userMail")
    private String mail;

//roller(collection??
    @ManyToMany(cascade = CascadeType.ALL
    )
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<Role>roles;

    @ManyToOne(cascade = CascadeType.ALL)
private Role role;

}
