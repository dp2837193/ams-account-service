package com.training.java.accountservice.controller;

import com.training.java.accountservice.entity.UserEntity;
import com.training.java.accountservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserEntity userEntity){
        try{
            userService.registerNewUser(userEntity);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("User "+userEntity.getFirstName()+" has been registered successfully!");
    }
}
