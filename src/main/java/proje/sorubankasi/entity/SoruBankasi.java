package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Sorubankasi")
public class SoruBankasi {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    @Column(name = "sorubankasiName")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

}
