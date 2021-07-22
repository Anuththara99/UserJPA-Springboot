package com.anu.springunijpa.service;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.exception.CourseNotFoundException;
import com.anu.springunijpa.exception.IdNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {


    /**
     * to add courses
     * @param course the new course
     * @return new course details
     */
    Course saveCourse(Course course);


    /**
     * to view all the courses
     * @return all the courses
     */
    List<Course> getCourse();


    /**
     * to view course by id
     * @param courseId the id of the course
     * @return the details of course that belongs to the course id
     */
    Course getCourseById(String courseId) throws IdNotFoundException;


    /**
     * to view course by course name
     * @param courseName name of the course
     * @return the details of the course that belongs to the course name
     */
    Course getCourseByName(String courseName) throws CourseNotFoundException;


    /**
     * to view course by course leader
     * @param courseLeader name of the course leader
     * @return the details of the course that belongs to the course leader
     */
    Course getCourseByLeader(String courseLeader) throws CourseNotFoundException;


    /**
     * to delete course by it's course id
     * @param courseId id of the course
     * @return  a message if successfully deleted
     */
    String deleteCourse(String courseId);


    /**
     * to update course using course id
     * @param course updated course
     * @return the updated course
     */
    Course updateCourse(Course course);
}
