package proje.sorubankasi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proje.sorubankasi.dto.request.TestAnswerRequestDTO;
import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.entity.Test;
import proje.sorubankasi.service.TestService;

import java.util.Map;

@RestController
@RequestMapping("/test")

public class TestController {
    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/")
    public ResponseEntity<Test> save(@RequestBody TestRequestDTO input) {
        var saveTest = testService.saveTest(input);

        return new ResponseEntity<Test>(saveTest, HttpStatus.CREATED);
    }

    @PutMapping("/{test_id}")
    public ResponseEntity<Test> update(@PathVariable long test_id, @RequestBody TestRequestDTO input) {
        var updateTest = testService.updateTest(test_id, input);
        return new ResponseEntity<>(updateTest, HttpStatus.OK);
    }

    @DeleteMapping("/{test_id}")
    public ResponseEntity<Test> deleteTest(@PathVariable long test_id) {
        var result = testService.deleteById(test_id);
        return new ResponseEntity<Test>(result, HttpStatus.OK);
    }

    @GetMapping("/{test_id}/add_question/{question_id}")
    public ResponseEntity<Test> addQuestion(@PathVariable Long test_id, @PathVariable Long question_id) {
        var result = testService.addQuestion(test_id, question_id);
        return new ResponseEntity<Test>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{test_id}/remove_question/{question_id}")//getmapping de olabilir!!
    public ResponseEntity<Test> deleteQuestion(@PathVariable Long test_id, @PathVariable long question_id) {
        var result = testService.deleteQuestion(test_id, question_id);
        return new ResponseEntity<Test>(result, HttpStatus.OK);
    }

    //sorulari arayüze tasimak icin kullanacımız component
    //soru ve sorubankasinda findById methoduyla olusturuldu burasida degistirilebilir!!!!
    @GetMapping("/{test_id}")
    public ResponseEntity<Test> viewTest(@PathVariable long test_id) {
        var result = testService.findById(test_id);
        return new ResponseEntity<Test>(result, HttpStatus.OK);
    }

    @PostMapping("/{test_id}/score")
    public ResponseEntity<Map<String,Integer>> denemeSonuc(@RequestBody TestAnswerRequestDTO answerRequest) {
        var result = testService.denemeSonuc(answerRequest);
        return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.OK);
    }


@GetMapping("/start-session/{sessionId}")
public ResponseEntity<?> testUrl(@PathVariable long testId){
        var result = testService.createTestSession(testId);
        return new ResponseEntity<>(result,HttpStatus.OK);
}
}
