package proje.sorubankasi.dto.response;

import lombok.Data;
import proje.sorubankasi.entity.Question;

@Data
public class QuestionResponseDTO {
    private Long id;
    private String text;
    private String options;

public QuestionResponseDTO(Question question){
    this.id=getId();
    this.text=getText();
    this.options=getOptions();
}

}
