package de.testtask.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(city, user.city) &&
                Objects.equals(postalCode, user.postalCode) &&
                Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, city, postalCode, country);
    }
}
