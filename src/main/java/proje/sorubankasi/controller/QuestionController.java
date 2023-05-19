package proje.sorubankasi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody QuestionRequestDTO input){
        var savedQuestion = questionService.saveQuestion(input);

        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

}
