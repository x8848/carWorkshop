package de.testtask.web;

import de.testtask.domain.Appointment;
import de.testtask.service.AppointmentReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentReposity repository;

    @PostConstruct
    private void postConstruct() {
        repository.save(new Appointment(1, "1", "bmw", "1", "2020-02-22T12:10:00"));
        repository.save(new Appointment(2, "1", "vw", "2", "2023-02-22T12:10:00"));
        repository.save(new Appointment(3, "2", "audi", "3", "2022-01-13T15:50:30"));
    }

    @GetMapping("/appointment")
    public List<Appointment> getAll() {
        return (List<Appointment>) repository.findAll();
    }

    @PostMapping("/appointment")
    public void create(@RequestBody Appointment appointment) {
        repository.save(appointment);
    }

    @GetMapping("/appointment/change")
    public List<Appointment> changeDateTime(@RequestParam String user, @RequestParam String company, @RequestParam String dateTime) {
        getAll().stream().filter(appointment -> user.equals(appointment.getUserName())
                && company.equals(appointment.getCompanyName()))
                .findAny()
                .ifPresent(appointment -> {
                    appointment.setDateTime(dateTime);
                    repository.save(appointment);
                });
        return getAll();
    }

    @GetMapping("/appointment/delete/{id}")
    public List<Appointment> deleteByName(@PathVariable long id) {
        repository.deleteById(id);
        return getAll();
    }

}