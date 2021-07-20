package com.anu.springunijpa.service;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface UserService {

    //to add new user
    User saveUser(User user);

    //to add list of new users
    List<User> saveUsers(List<User> users);

    //to view all the users
    Page<User> getUsers(Pageable page);

    //to search user by id
    User getUserById(int userId);

    //to search user by name
    User getUserByName(String userName);

    //to search user by telephone number
    User getUserByTel(String userTel);

    //to delete user
    String deleteUser(int userId);

    //to update user
    User updateUser(User user);

    //to search using id or name
    List<User> searchByIdOrName(int userId, String userName);




}
