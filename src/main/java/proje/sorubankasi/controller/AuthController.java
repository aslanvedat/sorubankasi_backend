package proje.sorubankasi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proje.sorubankasi.dto.request.AuthRequestDTO;
import proje.sorubankasi.dto.request.UserRequestDTO;
import proje.sorubankasi.dto.response.UserResponseDTO;
import proje.sorubankasi.service.AuthService;
import proje.sorubankasi.service.UserService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public UserResponseDTO signUp(@RequestBody UserRequestDTO request){
        return userService.save(request);
    }


    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequestDTO requestDTO) {
        String token = authService.authenticate(requestDTO);
        var response = Map.of("JwtToken",token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
