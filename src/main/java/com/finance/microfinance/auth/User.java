package com.finance.microfinance.auth;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "t_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_USER_Id", nullable = false, unique = true)
    private long Id;

    @Column(name = "c_USERNAME", unique = true, nullable = false)
    private String UserName;

    @Column(name = "c_PASSWORD", unique = true)
    private String Password;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

}
