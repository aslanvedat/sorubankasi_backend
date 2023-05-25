package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//sequence yerine ıdentity de olabilir??
    private long id;

    @Column(name = "testName")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

}
