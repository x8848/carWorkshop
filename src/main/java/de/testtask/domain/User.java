package de.testtask.domain;

public class User {

    private String name;
    private String email;
    private String city;
    private String postalCode;
    private String country;

    public User() {
    }

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
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
