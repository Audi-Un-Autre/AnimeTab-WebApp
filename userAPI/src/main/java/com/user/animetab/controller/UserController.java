package com.user.animetab.controller;

import java.util.List;

import com.user.animetab.model.UserModel;
import com.user.animetab.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<UserModel> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserModel user){
        String authCorrect = userService.authNewUser(user);

        if(authCorrect.equals("not_found")) userService.addNewUser(user);
        return authCorrect;
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody UserModel user){
        userService.deleteUser(user.getUserID());
    }

    @PostMapping("/login") // authentication point
    public ResponseEntity<?> checkLogin(@RequestBody UserModel user) throws Exception {
        return ResponseEntity.ok(userService.authLogin(user));
    }
}
