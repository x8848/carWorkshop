package de.testtask.domain;

import org.springframework.data.annotation.Id;

public class WorkShop {
    @Id
    private String name;
    private String[] tradeMarks;
    private String city;
    private String postalCode;
    private String country;

    public WorkShop(String name, String[] tradeMarks, String city, String postalCode, String country) {
        this.name = name;
        this.tradeMarks = tradeMarks;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String[] getTradeMarks() {
        return tradeMarks;
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