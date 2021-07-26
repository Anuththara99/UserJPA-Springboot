package com.anu.springunijpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "date_of_birth")
    private Date dOB;
    @Column(name = "user_tel")
    private String userTel;

    @OneToMany(mappedBy = "user")
    Set<UserCourse> user_course;

    public Set<UserCourse> getUser_course() {
        return user_course;
    }

    public void setUser_course(Set<UserCourse> user_course) {
        this.user_course = user_course;
    }
    //    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
//    @JoinTable(name = "user_course",
//            joinColumns =
//            @JoinColumn(name = "user_id")
//            ,
//            inverseJoinColumns =
//            @JoinColumn(name = "course_id"),
//            uniqueConstraints =
//                    {@UniqueConstraint(columnNames={"user_id", "course_id"})}
//
//    )
//    private List<Course> courses=new ArrayList<>();

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

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

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
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
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", dOB=" + dOB +
                ", userTel='" + userTel + '\'' +
                ", user_course=" + user_course +
                '}';
    }
}
