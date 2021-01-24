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

    public User findByUserID(int userID){
        return iUserDAO.findById(userID).get();
    }

    public void addNewUser(User newUser){
        iUserDAO.save(newUser);
    }

    public void deleteUser(int userID){
        iUserDAO.deleteById(userID);
    }
}
