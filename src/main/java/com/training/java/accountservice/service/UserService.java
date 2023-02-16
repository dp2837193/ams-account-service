package com.training.java.accountservice.service;

import com.training.java.accountservice.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, UserEntity> users = new HashMap<>();

    public void registerNewUser(UserEntity userEntity) throws Exception {
        if(users.containsKey(userEntity.getEmail())){
            throw new Exception("User exists");
        }
        this.users.put(userEntity.getEmail(), userEntity);
    }

    public UserEntity verifyUser(String email, String password) throws Exception{
        UserEntity userWithEmail = this.users.get(email);
        if(userWithEmail==null || !userWithEmail.getPassword().contentEquals(password)){
            throw new Exception("Invalid username or password");
        }
        return userWithEmail;
    }
}
