package com.user.animetab.controller;

import java.util.List;

import com.user.animetab.model.Session;
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
    public String addNewUser(@RequestBody User user){
        String authCorrect = userService.authNewUser(user);

        if(authCorrect.equals("not_found")) userService.addNewUser(user);
        return authCorrect;
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user.getUserID());
    }

    @PostMapping("/login")
    public Session checkLogin(@RequestBody User user){
        boolean authCorrect = userService.authLogin(user);
        if (authCorrect)
            return new Session(1, "login_success", "asdasddasda");
        else
            return new Session(0, "login_failure");
    }
}
