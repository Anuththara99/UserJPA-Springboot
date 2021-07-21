package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.entity.UserCourse;
import com.anu.springunijpa.repository.UserCourseRepository;
import com.anu.springunijpa.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public UserCourse createUserCourse(UserCourse userCourse) {
        return userCourseRepository.save(userCourse);
    }

    @Override
    public List<UserCourse> getUsers() {
        return userCourseRepository.findAll();
    }
}
