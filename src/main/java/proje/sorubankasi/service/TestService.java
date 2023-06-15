package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.entity.Test;

public interface TestService {

    Test findById(long id);

    Test saveTest(TestRequestDTO testRequestDTO);

    Test updateTest(long test_id, TestRequestDTO testRequestDTO);

    Test deleteById(long test_id);

    Test addQuestion(long testId, long questionId);

   Test deleteQuestion(Long test_id, long question_id);
   Test viewTest(long test_id);
}
