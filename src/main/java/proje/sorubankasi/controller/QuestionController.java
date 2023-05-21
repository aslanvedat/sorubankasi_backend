package proje.sorubankasi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proje.sorubankasi.dto.request.QuestionRequestDTO;
import proje.sorubankasi.entity.Question;
import proje.sorubankasi.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping("/")
    public ResponseEntity<Question> save(@RequestBody QuestionRequestDTO input){
        var savedQuestion = questionService.saveQuestion(input);

        return new ResponseEntity<Question>(savedQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody QuestionRequestDTO input){
        var updateQuestion = questionService.saveQuestion(input);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
    }
    //Question ve return kısmında değişiklikler olabilir



    @DeleteMapping("/{questions_id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable long questions_id){
        var result=questionService.deleteById(questions_id);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}




