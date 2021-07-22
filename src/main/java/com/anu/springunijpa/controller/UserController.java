package com.anu.springunijpa.controller;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //add user using userService
    @PostMapping("/users")
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
    @GetMapping("/users/name/{userName}")
    public User searchUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    //search user by user telephone number using userService
    @GetMapping("users/tel/{userTel}")
    public User searchUserByTel(@PathVariable String userTel) {
        return userService.getUserByTel(userTel);
    }

    //edit user by id using userService
    @PutMapping("/users/{userId}")
    public User editUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    //delete user by id using userService
    @DeleteMapping("/users/{userId}")
    public String removeUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }

    //to search user by id or user name
    @GetMapping("/users/idorname/{userId},{userName}")
    public ResponseEntity<List<User>> searchUserByIdOrName(@PathVariable("userId") int userId, @PathVariable("userName") String userName) {
        return new ResponseEntity<List<User>>(userService.searchByIdOrName(userId, userName), HttpStatus.OK);
    }

    @GetMapping("/users/search")
    public ResponseEntity<List<User>> searchByAny(@RequestParam String searchtype, @RequestParam String search) {
        return new ResponseEntity<List<User>>(userService.searchByIdOrNameOrTel(searchtype,search), HttpStatus.OK);
    }


}
