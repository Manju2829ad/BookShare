package com.basepackage.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_login")
public class Login {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long  login_id;


     @Column(name="emailOrMobileNumber",nullable=false)
    private String emailOrMobileNumber;

    @Column(name="login_password",nullable=false)
    private String password;


    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;


    
    @Column(name="login_timestamp",nullable=false,updatable=false)
    private LocalDateTime loginTimeStamp;



    @Column(name="logout_timestamp",updatable=false)
 private LocalDateTime  logoutTimeStamp;



    @PrePersist
    protected void onCreate() {
        this.loginTimeStamp = LocalDateTime.now(); // ✅ Set timestamp before saving
    }


    

}
