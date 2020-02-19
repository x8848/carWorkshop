package de.testtask.service;

import de.testtask.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentReposity extends CrudRepository<Appointment, Long> {
}
