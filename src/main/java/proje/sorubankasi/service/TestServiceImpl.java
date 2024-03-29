package proje.sorubankasi.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import proje.sorubankasi.dto.request.TestAnswerRequestDTO;
import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.dto.response.TestResponseDTO;

import proje.sorubankasi.entity.Test;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.TestRepostory;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepostory testRepostory;
    private final Map<String, Long> sessionMap;
    // Servisler ihtiyac halinde bir birlerini kullanabilirler
    private final QuestionService questionService;

    public TestServiceImpl(TestRepostory testRepostory, QuestionService questionService, Map<String,Long> sessionMap) {
        this.testRepostory = testRepostory;
        this.questionService = questionService;
        this.sessionMap = sessionMap;
    }

    @Override
    public Test findById(long id) {

        Optional<Test> testOptional = testRepostory.findById(id);
        return testOptional.orElseThrow(() -> new ApiRequestException("test is not found"));
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
        var test = findById(test_id);
        var question = questionService.findById(question_id);
        test.getQuestions().remove(question);
     return  testRepostory.save(test);
    }

    @Override
    public TestResponseDTO viewTest(long test_id) {
        var test = findById(test_id);
        return new TestResponseDTO(test);
    }

    @Override
    public Map<String, Integer> denemeSonuc(TestAnswerRequestDTO requestDTO) {
        var toplam = questionService.checkAnswers(requestDTO.getAnswers());
        Map<String, Integer> result = Map.of("result", toplam);//sonuc yazisindan emin degilim?
        return result;
    }

    @Override
    public Map<String,String> createTestSession(long testId) {
        var test = findById(testId);
        var sure = (long) test.getQuestions().size()*60;//60 ile carp sure bul
        var sessionId = UUID.randomUUID().toString().replace("-","");
        sessionMap.putIfAbsent(sessionId, sure);

        return Map.of("SessionId",sessionId);
    }


}
