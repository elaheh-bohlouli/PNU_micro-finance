package com.finance.microfinance.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_User")
public class User {
    @Id
    @Column(name = "c_USER_Id")
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
