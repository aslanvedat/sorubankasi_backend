package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.entity.Test;
import proje.sorubankasi.repostory.TestRepostory;

import java.util.Optional;


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
    public Test updateTest(long test_id, TestRequestDTO testRequestDTO) {
        Optional<Test> updateTest=testRepostory.findById(test_id);
        if (!updateTest.isPresent()){
            throw new RuntimeException("test not found:"+test_id);
        }
        Test test=new Test();
        test.setName(testRequestDTO.getName());
        test.setQuestions(testRequestDTO.getQuestions());//burasi degisebilir?

        return testRepostory.save(test);
    }
    @Override
    public Test deleteById(long test_id) {
        Optional<Test>theTest=testRepostory.findById(test_id);
        if(!theTest.isPresent())
        {

            throw new RuntimeException("test not found:"+test_id);
        }
        testRepostory.deleteById(test_id);
        return theTest.get();

    }

}
