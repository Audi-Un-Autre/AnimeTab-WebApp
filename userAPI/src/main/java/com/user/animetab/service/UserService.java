package com.user.animetab.service;

import java.util.List;

import com.user.animetab.model.User;
import com.user.animetab.dao.IUserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserService {

    @Autowired
    IUserDAO iUserDAO;

    public List<User> findAllUsers(){
        return iUserDAO.findAll();
    }

    public User findByUserID(Integer userID){
        return iUserDAO.findById(userID).get();
    }

    public void addNewUser(User newUser){
        // store hash of password in database
        /*
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        */
        iUserDAO.save(newUser);
    }

    public void deleteUser(Integer userID){
        iUserDAO.deleteById(userID);
    }

    public String authNewUser(User user){
        if (user == null) return null;

        User foundUser = iUserDAO.findByEmail(user.getEmail());
        if (foundUser != null) return "email_exists";

        User foundUsername = iUserDAO.findByUsername(user.getUsername());
        if (foundUsername != null) return "username_exists";
        return "not_found";
        
    }

    public boolean authLogin(User user){
        User foundUser = iUserDAO.findByEmail(user.getEmail());

        // email login does not exist
        if (foundUser == null) return false;

        // compare passwords of the found email
        if (foundUser.getPassword().equals(user.getPassword())){
            return true;
        }
        else
            return false;
    }
}
