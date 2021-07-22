package com.anu.springunijpa.repository;

import com.anu.springunijpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {


    User findByUserName(String userName);

    User findByUserTel(String userTel);

    List<User> findByUserIdOrUserName(int userId, String userName);

    List<User> findByUserIdOrUserNameOrUserTel(int userId, String userName, String userTel);


}
