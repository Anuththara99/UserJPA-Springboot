package com.anu.springunijpa.resolver;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.entity.UserInput;
import com.anu.springunijpa.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        mapper.registerModule(javaTimeModule);

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        user.setUserId(id);
        user.setUserName(name);
        user.setdOB(date);
        user.setUserTel(tel);
        return userRepository.save(user);
    }
}
