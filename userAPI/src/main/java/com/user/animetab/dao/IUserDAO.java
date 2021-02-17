package com.user.animetab.dao;

import com.user.animetab.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends JpaRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
    UserModel findByUsername(String username);
}
