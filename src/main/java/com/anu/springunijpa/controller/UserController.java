package com.anu.springunijpa.controller;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    //add user using userService
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    //view all user using userService with pagination
    @GetMapping("/users")
    public Page<User> viewAllUser(Pageable page) {
        return userService.getUsers(page);
    }

    //search user by id using userService
    @GetMapping("/users/{userId}")
    public User searchUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    //search user by userName using userService
    @GetMapping("/usern/{userName}")
    public User searchUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    //search user by user telephone number using userService
    @GetMapping("usert/{userTel}")
    public User searchUserByTel(@PathVariable String userTel){
        return userService.getUserByTel(userTel);
    }

    //edit user by id using userService
    @PutMapping("/user/{userId}")
    public User editUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    //delete user by id using userService
    @DeleteMapping("/user/{userId}")
    public String removeUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }

    //to search user by id or user name
    @GetMapping("/userm/idandname")
    public ResponseEntity<List<User>> searchUserByIdOrName(@RequestParam int userId, @RequestParam String userName){
        return new ResponseEntity<List<User>>(userService.searchByIdOrName(userId,userName), HttpStatus.OK);
    }
}
