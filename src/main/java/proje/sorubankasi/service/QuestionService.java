package proje.sorubankasi.service;


import org.springframework.http.ResponseEntity;
import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.entity.Question;

import java.util.Map;


public interface QuestionService {

    Question findById(long id);

    Question saveQuestion(QuestionRequestDTO requestDTO);

    Question deleteById(long questions_id);

    Question update(long id, QuestionRequestDTO requestDTO);

    Map<Long, Boolean> checkAnswer(long id, char choice);

}
