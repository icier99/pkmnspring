package ici.er.pkmn.controller;

import ici.er.pkmn.entity.UserDTO;
import ici.er.pkmn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class RegController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
        return new ResponseEntity<>("Пользователь зарегистрирован успешно", HttpStatus.CREATED);
    }
}