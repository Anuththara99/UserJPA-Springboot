package com.anu.springunijpa.repository;

import com.anu.springunijpa.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserName() {
        String name = "John";
        User user =userRepository.findByUserName(name);
        assertThat(user).isNotNull();
    }

    @Test
    void findByUserTel() {
    }

    @Test
    void findByUserIdOrUserName() {
    }

    @Test
    void findByUserIdOrUserNameOrUserTel() {
    }
}