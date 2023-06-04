package proje.sorubankasi.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.entity.Question;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.QuestionRepostory;

import java.util.Map;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepostory questionRepostory;

    public QuestionServiceImpl(QuestionRepostory questionRepostory) {
        this.questionRepostory = questionRepostory;
    }

    @Override
    public Question findById(long id) {

        Optional<Question> questionOptional = questionRepostory.findById(id);

        //return questionOptional.orElseThrow(()->new RuntimeException("Question is not found!"));
          return questionOptional.orElseThrow(()->new ApiRequestException("Question is not found"));
//bu sayfada baska yerlerde de kullanılmis
    }

    @Override
    public Question saveQuestion(QuestionRequestDTO requestDTO) {
        Question question = new Question();
        question.setText(requestDTO.getText());
        question.setOptions(requestDTO.getOptions());
        question.setAnswer(requestDTO.getAnswer());
        return questionRepostory.save(question);
    }


    @Override
    public Question deleteById(long questions_id) {
        Optional<Question> theQuestion = questionRepostory.findById(questions_id);
        if (!theQuestion.isPresent()) {
            throw new RuntimeException("question not found:" + questions_id);
        }
        questionRepostory.deleteById(questions_id);
        return theQuestion.get();
    }

    @Override
    public Question update(long id, QuestionRequestDTO requestDTO) {
        Question updateQuestion = findById(id);


        Question question = new Question();

        question.setText(requestDTO.getText());
        question.setOptions(requestDTO.getOptions());
        question.setAnswer(requestDTO.getAnswer());
        question.setId(id);

        return questionRepostory.save(question);
    }

    @Override
    public Map<Long, Boolean> checkAnswer(long id, char choice) {
        //soru cevapi kontrol edecek yapiyi olustur
        Optional<Question> theQuestion = questionRepostory.findById(id);
        boolean flac = false;
        var question = theQuestion.orElseThrow(() -> new RuntimeException("Kayit bulunamadi"));
        if (question.getAnswer() == choice) {
            flac = true;
        }
        Map<Long, Boolean> result = Map.of(id, flac);
        return result;

    }


}
