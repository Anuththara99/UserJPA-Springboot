package com.anu.springunijpa.service;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    User saveCourse(Course course);

    //to view all the coursers
    Page<User> getCourse(Pageable page);

    //to search Course by id
    User getCourseById(int courseId);

    //to search Course by name
    User getCourseByName(String courseName);

    //to search Course by course leader
    User getUserByLeader(String courseLeader);

    //to delete Course
    String deleteCourse(int courseId);

    //to update Course
    User updateCourse(Course course);
}
