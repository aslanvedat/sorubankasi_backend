package proje.sorubankasi.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    // question text
    private String text;

    @Column(name="option")
    private String options ;


    private char answer;




}
