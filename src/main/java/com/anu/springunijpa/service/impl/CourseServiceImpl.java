package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.CourseRepository;
import com.anu.springunijpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course saveCourse(Course course) {
        return null;
    }

    @Override
    public Page<User> getCourse(Pageable page) {
        return null;
    }

    @Override
    public Course getCourseById(int courseId) {
        return null;
    }

    @Override
    public Course getCourseByName(String courseName) {
        return null;
    }

    @Override
    public Course getUserByLeader(String courseLeader) {
        return null;
    }

    @Override
    public String deleteCourse(int courseId) {
        return null;
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }
}
