package com.anu.springunijpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserCourseKey implements Serializable {

    @Column(name = "user_id")
    int userId;

    @Column(name = "course_id")
    String courseId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCourseKey that = (UserCourseKey) o;
        return userId == that.userId && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }

    @Override
    public String toString() {
        return "UserCourseKey{" +
                "userId=" + userId +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
