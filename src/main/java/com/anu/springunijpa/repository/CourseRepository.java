package com.anu.springunijpa.repository;

import com.anu.springunijpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CourseRepository extends JpaRepository<Course, String> {

    Course findByCourseName(String courseName);

    Course findByCourseLeader(String courseLeader);
}
