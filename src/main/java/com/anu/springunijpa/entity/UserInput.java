package com.anu.springunijpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.time.LocalDate;

public class UserInput {

    private int userId;
    private String userName;
    @JsonProperty("dOB") @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dOB;
    private String userTel;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getdOB() {
        return dOB;
    }

    public void setdOB(LocalDate dOB) {
        this.dOB = dOB;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", dOB=" + dOB +
                ", userTel='" + userTel + '\'' +
                '}';
    }
}
