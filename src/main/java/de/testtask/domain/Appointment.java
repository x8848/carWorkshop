package de.testtask.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Appointment {
    @Id
    private long id;
    private String userName;
    private String tradeMark;
    private String companyName;
    private LocalDateTime dateTime;

    public Appointment(long id, String userName, String tradeMark, String companyName, String dateTime) {
        this.id = id;
        this.userName = userName;
        this.tradeMark = tradeMark;
        this.companyName = companyName;
        this.dateTime = LocalDateTime.parse(dateTime);
    }

    public long getId() {
        return id;
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

    public void setDateTime(String dateTime) {
        this.dateTime = LocalDateTime.parse(dateTime);
    }
}