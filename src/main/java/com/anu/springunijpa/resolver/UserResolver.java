package com.anu.springunijpa.resolver;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private  UserRepository userRepository;

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User findUser(int userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User findUserByName(String userName){
        return userRepository.findByUserName(userName);
    }

    public User findUserByTel(String userTel){
        return userRepository.findByUserTel(userTel);
    }

    public List<User> findByIdOrName(int userId,String username){
        return userRepository.findByUserIdOrUserName(userId,username);
    }

    public User createUser(String userName, LocalDate dOB,String userTel){
        User user=new User();
//        user.setUserId(userId);
        user.setUserName(userName);
        user.setdOB(dOB);
        user.setUserTel(userTel);
        return userRepository.save(user);
    }



}
