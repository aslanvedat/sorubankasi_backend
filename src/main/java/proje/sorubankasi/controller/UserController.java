package proje.sorubankasi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import proje.sorubankasi.dto.request.UserRequestDTO;
import proje.sorubankasi.dto.response.UserResponseDTO;
import proje.sorubankasi.entity.User;
import proje.sorubankasi.service.UserService;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class  UserController {

    private final UserService userService;

    @GetMapping("/")
    public Collection<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/")//buraya ekleme olabilir!
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO input){//responseEntity yerine collection olabilir?
        var saveUser=userService.save(input);
 return new ResponseEntity<UserResponseDTO>(saveUser,HttpStatus.CREATED);
    }

@DeleteMapping("/{user_id}")
public ResponseEntity<UserResponseDTO>delete(@PathVariable long user_id){
        var result=userService.deleteById(user_id);
        return new ResponseEntity<UserResponseDTO>(result,HttpStatus.OK);
}
@PutMapping("/{user_id}")
    public ResponseEntity<UserResponseDTO>update(@PathVariable long user_id,@RequestBody UserRequestDTO input){
        var updateUser=userService.update(user_id,input);
        return  new ResponseEntity<UserResponseDTO>(updateUser,HttpStatus.OK);
}



}
