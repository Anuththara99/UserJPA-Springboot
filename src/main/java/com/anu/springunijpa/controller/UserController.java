package com.anu.springunijpa.controller;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //view all user using userService
    @GetMapping("/users")
    public List<User> viewAllUser() {
        return userService.getUsers();
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
}
