package com.anu.springunijpa.entity;

import javax.persistence.*;

/**
 * user_course entity
 */

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

    String userCourseSet;

    public UserCourseKey getId() {
        return id;
    }

    public void setId(UserCourseKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "id=" + id +
                ", user=" + user +
                ", course=" + course +
                ", userCourseSet='" + userCourseSet + '\'' +
                '}';
    }
}
