package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;

    @Column(name="option")
    private String secenekler ;
//sorular HashMap<soru>???

@ManyToOne(cascade = CascadeType.ALL)
    private SoruBankasi soruBankasi;

    @ManyToOne
    private Test test;
}
