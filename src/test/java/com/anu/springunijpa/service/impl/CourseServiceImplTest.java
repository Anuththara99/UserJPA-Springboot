package com.anu.springunijpa.service.impl;

import com.anu.springunijpa.entity.Course;
import com.anu.springunijpa.entity.User;
import com.anu.springunijpa.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CourseServiceImplTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testSaveCourse() {
        Course course = new Course();
        course.setCourseId("c1");
        course.setCourseName("C");
        course.setCourseLeader("Mr.C");
        courseRepository.save(course);
        assertThat(course).isNotNull();
    }

    @Test
    void testGetCourse() {
        List<Course> courseList = courseRepository.findAll();
        assertThat(courseList).isNotEmpty();
    }

    @Test
    void testGetCourseById(){
        Course expectCourse = new Course();
        expectCourse.setCourseId("c1");
        expectCourse.setCourseName("C");
        expectCourse.setCourseLeader("Mr.C");
        entityManager.persist(expectCourse);
        entityManager.flush();
        Course course = courseRepository.findById("c1").get();
        assertThat(course).isEqualTo(expectCourse);
    }

    @Test
    void testGetCourseByName() {
        Course expectCourse = new Course();
        expectCourse.setCourseId("c1");
        expectCourse.setCourseName("C");
        expectCourse.setCourseLeader("Mr.C");
        entityManager.persist(expectCourse);
        entityManager.flush();
        Course course = courseRepository.findByCourseName("C");
        assertThat(course).isEqualTo(expectCourse);
    }

    @Test
    void testGetCourseByLeader() {
        Course expectCourse = new Course();
        expectCourse.setCourseId("c1");
        expectCourse.setCourseName("C");
        expectCourse.setCourseLeader("Mr.C");
        entityManager.persist(expectCourse);
        entityManager.flush();
        Course course = courseRepository.findByCourseLeader("Mr.C");
        assertThat(course).isEqualTo(expectCourse);
    }

    @Test
    void testDeleteCourse() {
        String id = "c1";
        courseRepository.deleteById(id);
        assertThat(courseRepository.existsById(id)).isFalse();
    }

    @Test
    void testUpdateCourse() {
        String id = "c1";
        Course course = courseRepository.findById(id).get();
        course.setCourseId("c1");
        course.setCourseName("C");
        course.setCourseLeader("Mr.C");
        courseRepository.save(course);
        assertThat(course).isNotNull();
    }
}