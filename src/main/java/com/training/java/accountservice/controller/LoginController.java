package com.training.java.accountservice.controller;

import com.training.java.accountservice.entity.UserEntity;
import com.training.java.accountservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> verifyUser(@RequestBody Map<String, String> login){
        try{
            UserEntity userFound = userService.verifyUser(login.get("email"), login.get("password"));
            return ResponseEntity.ok(userFound);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}