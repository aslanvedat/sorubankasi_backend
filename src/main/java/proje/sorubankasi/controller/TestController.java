package proje.sorubankasi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.entity.Test;
import proje.sorubankasi.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
private TestService testService;
    public TestController(TestService testService){
        this.testService=testService;
    }

@PostMapping("/")
    public ResponseEntity<Test>save(@RequestBody TestRequestDTO input){
       var saveTest=testService.saveTest(input);

    return new ResponseEntity<Test>(saveTest, HttpStatus.CREATED);
}

@PutMapping("/{test_id}")
public ResponseEntity<Test>update(@PathVariable long test_id,@RequestBody TestRequestDTO input){
      var updateTest=testService.updateTest(test_id,input);
      return  new ResponseEntity<>(updateTest,HttpStatus.OK);
}



@DeleteMapping("/{test_id}")
    public ResponseEntity<Test>deleteTest(@PathVariable long test_id){
        var result= testService.deleteById(test_id);
        return  new ResponseEntity<>(result,HttpStatus.OK);
}

}