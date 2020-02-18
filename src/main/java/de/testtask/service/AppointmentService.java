package de.testtask.service;

import de.testtask.domain.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    void createAppointment(String userName, String tradeMark, String companyName, LocalDateTime dateTime);

    void changeDateTime(String id, LocalDateTime dateTime);

    void deleteAppointment(String id);

    List<Appointment> getAllAppointments();

}
