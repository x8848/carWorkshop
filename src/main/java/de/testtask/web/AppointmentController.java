package de.testtask.web;

import de.testtask.domain.Appointment;
import de.testtask.service.AppointmentReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentReposity repository;

    @GetMapping("/appointment")
    public List getAll() {
        return (List) repository.findAll();
    }

    @PostMapping("/appointment")
    public void create(@RequestBody Appointment appointment) {
        repository.save(appointment);
    }

    @DeleteMapping("/appointment")
    void delete(@RequestBody Appointment appointment) {
        repository.delete(appointment);
    }

}