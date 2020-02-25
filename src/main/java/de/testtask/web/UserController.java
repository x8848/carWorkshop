package de.testtask.web;

import de.testtask.domain.User;
import de.testtask.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repository;

    @PostConstruct
    private void postConstruct() {
        repository.save(new User("a", "a", "kiev", "1", "ukraine"));
        repository.save(new User("b", "b", "munich", "1", "germany"));
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        if (getAll().stream().anyMatch(exist -> user.getName().equals(exist.getName()) ||
                user.getEmail().equals(exist.getEmail()))) {
            logger.error("Name or Email is already exists");
            return null;
        } else return repository.save(user);
    }

    @GetMapping("/user/delete/{name}")
    public List<User> deleteByName(@PathVariable String name) {
        repository.deleteById(name);
        return getAll();
    }
}