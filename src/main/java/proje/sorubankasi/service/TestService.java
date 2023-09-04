package proje.sorubankasi.service;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.dto.response.TestResponseDTO;
import proje.sorubankasi.entity.Test;
import  proje.sorubankasi.dto.request.TestAnswerRequestDTO;
import java.util.List;
import java.util.Map;

public interface TestService {

    Test findById(long id);

    Test saveTest(TestRequestDTO testRequestDTO);

    Test updateTest(long test_id, TestRequestDTO testRequestDTO);

    Test deleteById(long test_id);

    Test addQuestion(long testId, long questionId);

   Test deleteQuestion(Long test_id, long question_id);
   TestResponseDTO viewTest(long test_id);
   Map<String,Integer>denemeSonuc(TestAnswerRequestDTO requestDTO);

}
