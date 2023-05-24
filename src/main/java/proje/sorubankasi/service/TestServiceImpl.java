package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.entity.Test;
import proje.sorubankasi.repostory.TestRepostory;


public class TestServiceImpl implements TestService {
    private final TestRepostory testRepostory;

    public TestServiceImpl(TestRepostory testRepostory) {
        this.testRepostory = testRepostory;
    }

    @Override
    public Test saveTest(TestRequestDTO testRequestDTO) {
        Test test = new Test();
        test.setName(testRequestDTO.getName());
        test.setQuestions(testRequestDTO.getQuestions());
        return testRepostory.save(test);
    }

    @Override
    public Test deleteById(long test_id) {
        return null;
    }
}
