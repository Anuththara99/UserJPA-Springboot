package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.UserRepository;
import com.anu.springunijpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    //to add new user
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //to add list new users
    @Override
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    //to view all the users
    @Override
    public Page<User> getUsers(Pageable page) {
//        Pageable page = PageRequest.of(pageNumber,pageSize);
        return userRepository.findAll(page);
//        return userRepository.findAll();
    }

    //to search user by id
    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    //to search user by name
    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    //to search user by telephone number
    @Override
    public User getUserByTel(String userTel) {
        return userRepository.findByUserTel(userTel);
    }

    //to delete user by id
    @Override
    public String deleteUser(int userId) {
        userRepository.deleteById(userId);
        return "Successfully Removed User " + userId + "!!";
    }

    //to edit user by id
    @Override
    public User updateUser(User user) {
        User exUser = userRepository.findById(user.getUserId()).orElse(null);
        exUser.setUserName(user.getUserName());
        exUser.setdOB(user.getdOB());
        exUser.setUserTel(user.getUserTel());
        return userRepository.save(exUser);
    }

    @Override
    public List<User> searchByIdOrName(int userId, String userName) {
        return userRepository.findByUserIdOrUserName(userId,userName);
    }

    @Override
    public List<User> searchByIdOrNameOrTel(int userId, String userName, String userTel) {
        return userRepository.findByUserIdOrUserNameOrUserTel(userId,userName,userTel);
    }


}
