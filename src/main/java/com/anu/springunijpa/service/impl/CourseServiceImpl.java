package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.exception.CourseNotFoundException;
import com.anu.springunijpa.exception.IdNotFoundException;
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
        return courseRepository.findById(courseId).orElseThrow(()->new IdNotFoundException("Course Id not Found !!"));
    }

    @Override
    public Course getCourseByName(String courseName) {
        Course course=courseRepository.findByCourseName(courseName);
        if (course==null){
            throw new CourseNotFoundException("Course with this Name not found !!");
        }
        return course;
    }

    @Override
    public Course getCourseByLeader(String courseLeader) {
        Course course=courseRepository.findByCourseLeader(courseLeader);
        if (course==null){
            throw new CourseNotFoundException("Course with this Leader not found !!");
        }
        return course;
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
