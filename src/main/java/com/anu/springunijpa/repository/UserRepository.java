package com.anu.springunijpa.repository;

import com.anu.springunijpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer>{

    User findByName(String userName);
}
