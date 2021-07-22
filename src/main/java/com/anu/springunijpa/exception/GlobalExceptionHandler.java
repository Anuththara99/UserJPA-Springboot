package com.anu.springunijpa.exception;

import com.anu.springunijpa.entity.Error;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex){
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("User not Found !");
        HttpStatus status=HttpStatus.BAD_REQUEST;
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleUserIdNotFoundException(IdNotFoundException ex){
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Id not Found !");
        HttpStatus status=HttpStatus.NOT_FOUND;
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception ex){
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Other Exception !");
        HttpStatus status=HttpStatus.BAD_REQUEST;
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Request method Not supported !");
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Media  Not supported !");
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Media  Not Acceptable !");
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Path variable is missing !");
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Request body is not Readable !!");
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Incorrect Type !!");
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message= ex.getMessage();
        List<String> details= new ArrayList<>();
        details.add("Request param is Missing  !!");
        Error error= new Error(message,details, LocalDateTime.now(),status);
        return ResponseEntity.status(status).body(error);
    }
}
