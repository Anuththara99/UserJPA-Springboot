package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.entity.UserCourse;
import com.anu.springunijpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void saveUser() {
    }

    @Test
    void saveUsers() {
    }

    @Test
    void getUsers() {
    }

    @Test
    void getUserById() {
//        int id =3;
////        User userObj=new User();
//        User user = userRepository.findById(id).get();
//        Date date= new Date(2001,12,10);
////        userCourseSet.add()
//        User expectUser = new User(3,"Kate",date,"767097796");
//        assertEquals(expectUser,user);
    }

    @Test
    void getUserByName() {
    }

    @Test
    void getUserByTel() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void searchByIdOrName() {
    }

    @Test
    void searchByIdOrNameOrTel() {
    }
}