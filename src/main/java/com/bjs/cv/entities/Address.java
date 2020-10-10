package com.bjs.cv.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
public class Address {
    @Getter
    @Setter
    private String streetName;
    @Getter
    @Setter
    private String postCode;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String country;

    public Address(){

    }

    public Address(String streetName, String postCode, String city, String country) {
        this.streetName = streetName;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }
}
