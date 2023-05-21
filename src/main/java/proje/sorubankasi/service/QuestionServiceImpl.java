package proje.sorubankasi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.entity.Question;
import proje.sorubankasi.repostory.QuestionRepostory;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepostory questionRepostory;

    public QuestionServiceImpl(QuestionRepostory questionRepostory) {
        this.questionRepostory = questionRepostory;
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
       Optional<Question>theQuestion=questionRepostory.findById(questions_id);
        if(!theQuestion.isPresent()){
            throw new RuntimeException("employee id not found:"+questions_id);
        }
        questionRepostory.deleteById(questions_id);
       return theQuestion.get();
    }
}
