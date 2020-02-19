package de.testtask.domain;

import java.time.LocalDateTime;

public class Appointment {

    private String userName;
    private String tradeMark;
    private String companyName;
    private LocalDateTime dateTime;

    public Appointment(String userName, String tradeMark, String companyName, LocalDateTime dateTime) {
        this.userName = userName;
        this.tradeMark = tradeMark;
        this.companyName = companyName;
        this.dateTime = dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}