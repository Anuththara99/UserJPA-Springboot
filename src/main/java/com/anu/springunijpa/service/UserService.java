package com.anu.springunijpa.service;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //to add new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //to add list new users
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    //to view all the users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //to search user by id
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    //to search user by name
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    //to search user by telephone number
    public User getUserByTel(String userTel){
        return userRepository.findByUserTel(userTel);
    }

    //to delete user by id
    public String deleteUser(int userId) {
        userRepository.deleteById(userId);
        return "Successfully Removed User " + userId + "!!";
    }

    //to edit user by id
    public User updateUser(User user) {
        User exUser = userRepository.findById(user.getUserId()).orElse(null);
        exUser.setUserName(user.getUserName());
        exUser.setdOB(user.getdOB());
        exUser.setUserTel(user.getUserTel());
        return userRepository.save(exUser);
    }
}
