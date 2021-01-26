package com.user.animetab.controller;

import java.util.List;

import com.user.animetab.model.User;
import com.user.animetab.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/new")
    public void addNewUser(@RequestBody User newUser){
        userService.addNewUser(newUser);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user.getUserID());
    }

    
    @PostMapping("/login")
    public String checkLogin(@RequestBody User user){
        boolean authCorrect = userService.authLogin(user);
        if (authCorrect)
            return "User found.";
        else
            return "User does not exist.";
    }
}
