

package com.user.animetab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userID;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(columnDefinition = "enum('ADMIN', 'MODERATOR', 'MEMBER', 'LIMITED', 'SUSPENDED', 'BANNED')")
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserModel(){}

    public UserModel(String email, String username, String password, Role role){
        this.email = email;
        this.username = username;
        this.password = password;
    }


    // ****  GET   ****

    public int getUserID(){
        return userID;
    }

    public String getEmail(){
        return email;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public Role getRole(){
        return role;
    }

    // ****   SET  ****

    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    // -> only admin can use this function in more developed model <-
    public void setRole(Role role){
        this.role = role;
    }
}
