package com.anu.springunijpa.resolver;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.entity.UserInput;
import com.anu.springunijpa.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class UserMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserInput userInput){
        User user =new User();
        int id = userInput.getUserId();
        String name =userInput.getUserName();
        LocalDate date = userInput.getdOB();
        String tel= userInput.getUserTel();
        user.setUserId(id);
        user.setUserName(name);
        user.setdOB(date);
        user.setUserTel(tel);
        return userRepository.save(user);
    }
}
