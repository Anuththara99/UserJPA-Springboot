package com.anu.springunijpa.entity;

public class CourseUpdateInput {
    private String courseId;
    private String courseName;
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
        return "CourseInput{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseLeader='" + courseLeader + '\'' +
                '}';
    }
}
