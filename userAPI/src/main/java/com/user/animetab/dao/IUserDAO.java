package com.user.animetab.dao;

import com.user.animetab.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUsername(String username);
}
