package proje.sorubankasi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.entity.Question;
import proje.sorubankasi.service.QuestionService;

import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/")
    public ResponseEntity<Question> save(@RequestBody QuestionRequestDTO input) {
        var savedQuestion = questionService.saveQuestion(input);

        return new ResponseEntity<Question>(savedQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/{questions_id}")
    public ResponseEntity<Question> update(@PathVariable long questions_id, @RequestBody QuestionRequestDTO input) {
        var updateQuestion = questionService.update(questions_id, input);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
    }


    @DeleteMapping("/{questions_id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable long questions_id) {
        var result = questionService.deleteById(questions_id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/check_answer")
    public ResponseEntity<Map<Long, Boolean>> checkAnswer(@PathVariable long id, @PathVariable char choice) {
        var result = questionService.checkAnswer(id, choice);
        return new ResponseEntity<Map<Long, Boolean>>(result, HttpStatus.OK);

    }
}




