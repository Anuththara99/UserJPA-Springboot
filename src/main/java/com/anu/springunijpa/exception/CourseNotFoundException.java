package com.anu.springunijpa.exception;


public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }
}
