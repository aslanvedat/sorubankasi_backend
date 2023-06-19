package proje.sorubankasi.dto.response;

import lombok.Data;
import proje.sorubankasi.entity.Test;

import java.util.List;

@Data
public class TestResponseDTO {

    private Long id;
    private String name;
    private List<QuestionResponseDTO> questions;

    public TestResponseDTO(Long id, String name, List<QuestionResponseDTO> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public TestResponseDTO(Test test) {
        this.id = test.getId();
        this.name = test.getName();
        this.questions = test.getQuestions().stream().map(QuestionResponseDTO::new).toList();
    }


}
