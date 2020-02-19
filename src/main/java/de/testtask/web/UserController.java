package de.testtask.web;

import de.testtask.domain.User;
import de.testtask.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    public List getAll() {
        return (List) repository.findAll();
    }

    @PostMapping("/user")
    public void create(@RequestBody User user) {
        repository.save(user);
    }

    @DeleteMapping("/user")
    void delete(@RequestBody User user) {
        repository.delete(user);
    }
}