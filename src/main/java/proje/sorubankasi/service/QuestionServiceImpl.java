package proje.sorubankasi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.entity.Question;
import proje.sorubankasi.repostory.QuestionRepostory;

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
}
