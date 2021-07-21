package com.anu.springunijpa.controller;

import com.anu.springunijpa.entity.UserCourse;
import com.anu.springunijpa.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCourseController {

    @Autowired
    private UserCourseService userCourseService;

    @PostMapping("/usercourses")
    public UserCourse addUserCourse(UserCourse userCourse) {
        return userCourseService.createUserCourse(userCourse);
    }

    @GetMapping("/usercourses")
    public List<UserCourse> viewUserCourse() {
        return userCourseService.getUsers();
    }
}
