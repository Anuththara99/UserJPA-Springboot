package com.anu.springunijpa.entity;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Error {

    private String message;
    private List<String> details;
    private LocalDateTime timeStamp;
    private HttpStatus status;

}
