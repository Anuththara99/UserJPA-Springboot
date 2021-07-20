package com.anu.springunijpa.controller;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    //add course using courseService
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    //view all course using courseService with pagination
    @GetMapping("/courses")
    public List<Course> viewAllCourse() {
        return courseService.getCourse();
    }

    //search course by id using courseService
    @GetMapping("/courses/{courseId}")
    public Course searchCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }
    //search course by courseName using courseService
    @GetMapping("/courses/name/{courseName}")
    public Course searchCourseByName(@PathVariable String courseName) {
        return courseService.getCourseByName(courseName);
    }

    //search course by course leader using courseService
    @GetMapping("courses/leader/{courseLeader}")
    public Course searchCourseByLeader(@PathVariable String courseLeader){
        return courseService.getCourseByLeader(courseLeader);
    }

    //edit course by id using courseService
    @PutMapping("/courses/{courseId}")
    public Course editCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }
    //delete course by id using courseService
    @DeleteMapping("/courses/{courseId}")
    public String removeCourse(@PathVariable String courseId) {
        return courseService.deleteCourse(courseId);
    }

}
