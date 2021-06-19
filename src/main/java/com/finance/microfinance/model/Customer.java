package com.finance.microfinance.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "t_Customer")
public class Customer extends Entities {

    @Column(name = "c_Code")
    private String code;

    @Column(name = "c_Name")
    private String name;

    @Column(name = "c_LastName")
    private String lastName;

    @Column(name = "c_InternationalCode")
    private String internationalCode;

    @Column(name = "c_PortionNumber")
    private String portionNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInternationalCode() {
        return internationalCode;
    }

    public void setInternationalCode(String internationalCode) {
        this.internationalCode = internationalCode;
    }

    public String getPortionNumber() {
        return portionNumber;
    }

    public void setPortionNumber(String portionNumber) {
        this.portionNumber = portionNumber;
    }
}