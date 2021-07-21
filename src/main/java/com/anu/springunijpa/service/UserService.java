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


    /**
     * to add new user
     * @param user the new user
     * @return new user details
     */
    User saveUser(User user);


    /**
     * to add list of new users
     * @param users new users
     * @return list of new users
     */
    List<User> saveUsers(List<User> users);


    /**
     * to view all the users
     * @param page the page size and number of pages
     * @return all the users
     */
    Page<User> getUsers(Pageable page);


    /**
     * to view user by id
     * @param userId the id of the user
     * @return the user details belongs to the id
     */
    User getUserById(int userId);


    /**
     * to view user by name
     * @param userName the name of the user
     * @return the user details belongs to the name
     */
    User getUserByName(String userName);


    /**
     * to view user by telephone number
     * @param userTel the telephone number of the user
     * @return the user details belongs to the telephone number
     */
    User getUserByTel(String userTel);


    /**
     * to delete user by user id
     * @param userId the id of the user
     * @return  a message if successfully deleted
     */
    String deleteUser(int userId);


    /**
     * to update the user by id
     * @param user the updated user
     * @return updated details of the existing user
     */
    User updateUser(User user);


    /**
     * to search user using id or name
     * @param userId   the id of the user
     * @param userName the name of the user
     * @return list of users
     */
    List<User> searchByIdOrName(int userId, String userName);

    List<User> searchByIdOrNameOrTel(int userId,String userName,String userTel);


}
