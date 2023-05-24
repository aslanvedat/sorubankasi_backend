package proje.sorubankasi.dto.request;

import lombok.Data;
import proje.sorubankasi.entity.Question;

import java.util.List;

//bu class olmayabilir?
@Data
public class TestRequestDTO {
    private  long id;
    private String name;
    private List<Question> questions;//QuestionDTO olabilir?
}
