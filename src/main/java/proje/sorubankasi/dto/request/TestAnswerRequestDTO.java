package proje.sorubankasi.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class TestAnswerRequestDTO  {
    private long testId;
    private List<AnswerRequestDTO>answers;
}
