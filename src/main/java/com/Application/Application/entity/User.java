package com.Application.Application.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_No")
    private Integer userId;

    @Column(name="Email_Id",unique = true)
    private String userEmail;

    @Column(name="Password")
    private String userPassword;

    @Temporal(TemporalType.DATE)
    @Column(name="DOB")
    private Date dateOfBirth;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},mappedBy = "user", fetch = FetchType.EAGER)
    private UserDetails userDetails;

    @Column(name="Id_Created_On",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @Column(name="Last_Updated",nullable = false,updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;

    public User(int userId, String userEmail, String userPassword,Date dateOfBirth,Date createdDate,Date updatedDate) {

        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.dateOfBirth = dateOfBirth;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;

    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
