package com.anu.springunijpa;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class SpringUniJpaApplicationTests {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void saveUser() {
//        User user = new User();
//        user.setUserId(2);
//        user.setUserName("Koli");
//        user.setUserTel("0789898789");
//        LocalDate date = LocalDate.of(1999,9,04);
//        user.setdOB(date);
//        User newUser = userRepository.save(user);
//        assertNotNull(newUser);

//    }
//
//    @Test
//    void getUserById() {
//        LocalDate date= LocalDate.of(1999,5,2);
//        User expectUser = new User(1,"John",date,"709709234");
//
//        User user = userRepository.findById(9).get();
//        assertThat(user).isEqualTo(expectUser);
//    }

}
