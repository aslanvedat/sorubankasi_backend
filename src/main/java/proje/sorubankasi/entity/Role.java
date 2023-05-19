package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Role")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private long id;

@Column(name="rolName")
private String name;

//@OneToMany(cascade = CascadeType.ALL)
////    private List<User> users;
}
