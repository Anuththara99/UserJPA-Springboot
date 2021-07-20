package com.anu.springunijpa.service;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {

    Course saveCourse(Course course);

    //to view all the coursers
    Page<User> getCourse(Pageable page);

    //to search Course by id
    Course getCourseById(int courseId);

    //to search Course by name
    Course getCourseByName(String courseName);

    //to search Course by course leader
    Course getUserByLeader(String courseLeader);

    //to delete Course
    String deleteCourse(int courseId);

    //to update Course
    Course updateCourse(Course course);
}
