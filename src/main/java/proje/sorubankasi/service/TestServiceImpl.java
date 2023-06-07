package proje.sorubankasi.service;

import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.entity.Test;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.TestRepostory;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepostory testRepostory;

    // Servisler ihtiyac halinde bir birlerini kullanabilirler
    private final QuestionService questionService;

    public TestServiceImpl(TestRepostory testRepostory, QuestionService questionService) {
        this.testRepostory = testRepostory;
        this.questionService = questionService;
    }

    @Override
    public Test findById(long id) {

        Optional<Test> testOptional = testRepostory.findById(id);
        return testOptional.orElseThrow(()->new ApiRequestException("test is not found"));
      //  return testOptional.orElseThrow(() -> new RuntimeException("Test is not found!"));
    }

    @Override
    public Test saveTest(TestRequestDTO testRequestDTO) {
        Test test = new Test();
        test.setName(testRequestDTO.getName());
        return testRepostory.save(test);
    }


    @Override
    public Test updateTest(long test_id, TestRequestDTO testRequestDTO) {
        var test = findById(test_id);
        test.setName(testRequestDTO.getName());

        return testRepostory.save(test);
    }

    @Override
    public Test deleteById(long test_id) {
        var test = findById(test_id);
        testRepostory.delete(test);
        return test;

    }

    @Override
    public Test addQuestion(long testId, long questionId) {

        var test = findById(testId); // testi bul
        var question = questionService.findById(questionId); // question'i bul

        test.getQuestions().add(question); // test'e soru ekle

        return testRepostory.save(test); // veri tabanina kaydet ve don
    }

    @Override
    public Test deleteQuestion(Long test_id, long question_id) {
        var test=findById(test_id);
        var question=questionService.findById(question_id);
        test.getQuestions().remove(question);

        return test;//burasi degisebilir
    }


}
