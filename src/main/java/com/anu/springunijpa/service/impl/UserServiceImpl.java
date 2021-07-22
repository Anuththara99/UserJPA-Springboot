package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.controller.UserController;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.exception.IdNotFoundException;
import com.anu.springunijpa.exception.UserNotFoundException;
import com.anu.springunijpa.repository.UserRepository;
import com.anu.springunijpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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
        Page<User> userList = userRepository.findAll(page);
        if (userList.isEmpty()) {
            throw new UserNotFoundException("No users found !");
        }
        return userList;
    }

    //to search user by id
    @Override
    public User getUserById(int userId) {
        logger.info("user id -"+userId);
        return userRepository.findById(userId).orElseThrow(() -> new IdNotFoundException("User with this Id not found!!"));
    }

    //to search user by name
    @Override
    public User getUserByName(String userName) {
        User user=userRepository.findByUserName(userName);
        logger.info("user name -"+userName);
        if (user==null){
            throw new UserNotFoundException("User with this name not found !");
        }
        return user;
    }

    //to search user by telephone number
    @Override
    public User getUserByTel(String userTel) {
        logger.info("user tel -"+userTel);
        User user = userRepository.findByUserTel(userTel);
        if (user==null){
            throw new UserNotFoundException("User with this telephone number not found!");
        }
        return user;
    }

    //to delete user by id
    @Override
    public String deleteUser(int userId) {
        logger.info("user id -"+userId);
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
        List<User> userList=userRepository.findByUserIdOrUserName(userId, userName);
        if (userList.isEmpty()){
            throw new UserNotFoundException("User with this name or id not found !!");
        }
        return userList;
    }

    @Override
    public List<User> searchByIdOrNameOrTel(String searchtype,String search) {
        int userId = 0;
        String userName =null;
        String userTel =null;
//        Optional<String> name=Optional.ofNullable(userName);
        if (searchtype.equals("id")) {
            int id = Integer.parseInt(search);
            userId = id;
        } else if (searchtype.equals("name")) {
            userName = search;
        } else if (searchtype.equals("tel")) {
            userTel = search;
        }
        List<User> userList=userRepository.findByUserIdOrUserNameOrUserTel(userId, userName, userTel);
        if(userList.isEmpty()){
            throw new UserNotFoundException("User with this "+searchtype+" not found");
        }
        return userList;
    }


}
