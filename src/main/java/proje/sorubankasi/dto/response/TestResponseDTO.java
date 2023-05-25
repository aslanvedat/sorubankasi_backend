package proje.sorubankasi.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class TestResponseDTO {

    private Long id;
    private String name;
    private List<QuestionResponseDTO> questions;

}
