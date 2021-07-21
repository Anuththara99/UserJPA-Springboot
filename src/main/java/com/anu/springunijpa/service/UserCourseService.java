package com.anu.springunijpa.service;

import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.entity.UserCourse;

import java.util.List;

public interface UserCourseService {

    UserCourse createUserCourse(UserCourse userCourse);

    List<UserCourse> getUsers();
}
