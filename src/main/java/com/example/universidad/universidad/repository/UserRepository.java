package com.example.universidad.universidad.repository;

import org.springframework.stereotype.Repository;

import com.example.universidad.universidad.entity.User;



@Repository
public class UserRepository {
    public User findUserByEmail(String email){
        User user = new User(email,"123456");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }
}
