package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.entity.UserCourseKey;
import com.anu.springunijpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceImplTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("John");
        user.setUserTel("0701000111");
        LocalDate date = LocalDate.of(1999,5,2);
        user.setdOB(date);
        User newUser = userRepository.save(user);
        assertNotNull(newUser);

    }


    @Test
    void testGetUsers() {
        Iterable<User> userList = userRepository.findAll();
        assertThat(userList).isNotEmpty();
    }

    @Test
    void getUserById() {
        LocalDate date= LocalDate.of(1999,5,2);
        User expectUser = new User();
        expectUser.setUserId(3);
        expectUser.setUserName("John");
        expectUser.setdOB(date);
        expectUser.setUserTel("0701000111");
        testEntityManager.merge(expectUser);
        testEntityManager.flush();
        User user = userRepository.findById(3).get();
        assertThat(user).isEqualTo(expectUser);
    }

    @Test
    void getUserByName(){
        String name = "John";
        User user =userRepository.findByUserName(name);
        assertThat(user).isNotNull();
    }

    @Test
    void getUserByTel() {
        String tel= "0701000111";
        User user=userRepository.findByUserTel(tel);
        assertThat(user).isNotNull();
    }

    @Test
    void deleteUser() {
        int id = 1;
        userRepository.deleteById(id);
        assertThat(userRepository.existsById(1)).isFalse();
    }

    @Test
    void updateUser() {
        User user = userRepository.findById(2).get();
        user.setUserName("John");
        user.setUserTel("709709234");
        userRepository.save(user);
        assertThat(user).isNotNull();
    }

    @Test
    void searchByIdOrName() {
        int id = 8;
        String name = "John";
        List<User> userList= userRepository.findByUserIdOrUserName(id,name);
        assertThat(userList).isNotEmpty();
    }

    @Test
    void searchByIdOrNameOrTel() {
        int id = 8;
        String name ="John";
        String tel = "709709234";
        List<User> userList = userRepository.findByUserIdOrUserNameOrUserTel(id,name,tel);
        assertThat(userList).isNotEmpty();
    }
}