package de.testtask.domain;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String name;
    private String email;
    private String city;
    private String postalCode;
    private String country;

    public User(String name, String email, String city, String postalCode, String country) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}
