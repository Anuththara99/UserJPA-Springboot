package com.anu.springunijpa.resolver;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.CourseInput;
import com.anu.springunijpa.entity.CourseUpdateInput;
import com.anu.springunijpa.exception.IdNotFoundException;
import com.anu.springunijpa.repository.CourseRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(CourseInput courseInput){
        Course course=new Course();
        String id = courseInput.getCourseId();
        String name = courseInput.getCourseName();
        String leader = courseInput.getCourseLeader();
        course.setCourseId(id);
        course.setCourseName(name);
        course.setCourseLeader(leader);
        return courseRepository.save(course);
    }

    public Course updateCourse(CourseUpdateInput courseUpdateInput){
        Course course = courseRepository.findById(courseUpdateInput.getCourseId()).orElseThrow(()-> new IdNotFoundException("User with this Id not found!!"));
        String name = courseUpdateInput.getCourseName();
        String leader = courseUpdateInput.getCourseLeader();
        course.setCourseName(name);
        course.setCourseLeader(leader);
        return courseRepository.save(course);
    }
}
