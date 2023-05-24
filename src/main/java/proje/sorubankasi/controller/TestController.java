package proje.sorubankasi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
