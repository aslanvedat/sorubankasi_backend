package proje.sorubankasi.service;


import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.entity.Question;


public interface QuestionService {
    Question saveQuestion(QuestionRequestDTO requestDTO);

   Question deleteById(long questions_id);
   Question update(long id,QuestionRequestDTO requestDTO);
}
