package com.anu.springunijpa.entity;

import javax.persistence.*;

@Entity
public class UserCourse {

    @EmbeddedId
    UserCourseKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    String user_course;

    public UserCourseKey getId() {
        return id;
    }

    public void setId(UserCourseKey id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

    public String getUser_course() {
        return user_course;
    }

    public void setUser_course(String user_course) {
        this.user_course = user_course;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "id=" + id +
                ", user=" + user +
                ", course=" + course +
                ", user_course=" + user_course +
                '}';
    }
}
