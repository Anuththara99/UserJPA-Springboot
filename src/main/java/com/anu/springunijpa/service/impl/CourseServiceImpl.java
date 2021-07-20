package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.CourseRepository;
import com.anu.springunijpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public Course getCourseByName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @Override
    public Course getCourseByLeader(String courseLeader) {
        return courseRepository.findByCourseLeader(courseLeader);
    }

    @Override
    public String deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
        return "Successfully Removed User " + courseId + "!!";
    }

    @Override
    public Course updateCourse(Course course) {
        Course exCourse =courseRepository.findById(course.getCourseId()).orElse(null);
        exCourse.setCourseName(course.getCourseName());
        exCourse.setCourseLeader(course.getCourseLeader());
        return courseRepository.save(exCourse);
    }
}
