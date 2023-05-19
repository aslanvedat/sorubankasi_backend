package proje.sorubankasi.dto.request;

import lombok.Data;

@Data
public class QuestionRequestDTO {

    private String text;
    private String options;
    private char answer;

}
