package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.LinkedList;

@Data
@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "rolName")
    private String name;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }


    //@OneToMany(cascade = CascadeType.ALL)
////    private List<User> users;
}
