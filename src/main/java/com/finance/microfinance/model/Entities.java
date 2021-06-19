package com.finance.microfinance.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class Entities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "c_createDateTime")
    private Date createDate;

    @Column(name = "c_lastModifiedDateTime")
    private Date lastModifiedDataTime;

    @Column(name = "c_active")
    private Boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLastModifiedDataTime() {
        return lastModifiedDataTime;
    }

    public void setLastModifiedDataTime(Date lastModifiedDataTime) {
        this.lastModifiedDataTime = lastModifiedDataTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
