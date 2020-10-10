package com.bjs.cv.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -2216756051002651100L;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer age;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    @Embedded
    @Column(nullable = false)
    private Address address;


    public UserInfo(String name, Integer age, String phoneNumber, Address address){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UserInfo() {

    }
}