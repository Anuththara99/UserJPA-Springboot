package com.anu.springunijpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private String courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_ledear")
    private String courseLeader;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLeader() {
        return courseLeader;
    }

    public void setCourseLeader(String courseLeader) {
        this.courseLeader = courseLeader;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseLeader='" + courseLeader + '\'' +
                '}';
    }
}
