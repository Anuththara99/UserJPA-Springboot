package com.anu.springunijpa.resolver;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.CourseRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseResolver implements GraphQLQueryResolver {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> allCourses() {
        return courseRepository.findAll();
    }

    public Course findCourse(String courseId){
        return courseRepository.findById(courseId).orElse(null);
    }

}
