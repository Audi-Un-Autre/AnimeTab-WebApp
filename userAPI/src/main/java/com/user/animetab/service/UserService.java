package com.user.animetab.service;

import java.util.List;
import java.util.ArrayList;

import com.user.animetab.model.Session;
import com.user.animetab.model.UserModel;
import com.user.animetab.util.JwtUtil;
import com.user.animetab.dao.IUserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    IUserDAO iUserDAO;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserModel user = iUserDAO.findByEmail(email);
        UserDetails springUser = new User(user.getEmail(), user.getPassword(), new ArrayList<>());
        return springUser;
    }

    public List<UserModel> findAllUsers(){
        return iUserDAO.findAll();
    }

    public UserModel findByUserID(Integer userID){
        return iUserDAO.findById(userID).get();
    }

    public void addNewUser(UserModel newUser){
        // store hash of password
        //newUser.setPassword(encoder.encode(newUser.getPassword()));

        iUserDAO.save(newUser);
    }

    public void deleteUser(Integer userID){
        iUserDAO.deleteById(userID);
    }

    public String authNewUser(UserModel user){
        if (user == null) return null;

        UserModel foundUser = iUserDAO.findByEmail(user.getEmail());
        if (foundUser != null) return "email_exists";

        UserModel foundUsername = iUserDAO.findByUsername(user.getUsername());
        if (foundUsername != null) return "username_exists";
        return "not_found";
        
    }

    public Session authLogin(UserModel user){
        try{
            authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        } catch (BadCredentialsException e) {
            // no token
            return new Session(0, "login_fail", null);
        }

        // create token
        final UserDetails userDetails = this.loadUserByUsername(user.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new Session(1, "login_success", jwt);
    }
}
