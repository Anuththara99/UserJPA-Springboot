package com.anu.springunijpa.service;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

    //to add coursers
    Course saveCourse(Course course);

    //to view all the coursers
    List<Course> getCourse();

    //to search Course by id
    Course getCourseById(String courseId);

    //to search Course by name
    Course getCourseByName(String courseName);

    //to search Course by course leader
    Course getCourseByLeader(String courseLeader);

    //to delete Course
    String deleteCourse(String courseId);

    //to update Course
    Course updateCourse(Course course);
}
