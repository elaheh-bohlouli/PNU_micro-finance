package com.finance.microfinance.auth;

import javax.persistence.*;

@Entity
@Table(name = "t_AUTH_USER_GROUP")
public class AuthGroup {
    @Id
    @Column(name = "c_AUTH_USER_GROUP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "c_USER_NAME")
    private String userName;

    @Column(name = "c_AUTH_GROUP")
    private String authGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }
}
