package de.testtask.service;

import de.testtask.domain.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    void deleteUser(long id);

    List getAllUsers();

}