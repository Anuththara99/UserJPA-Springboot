package com.anu.springunijpa.repository;

import com.anu.springunijpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository <User,Integer>{

    User findByUserName(String userName);
}
