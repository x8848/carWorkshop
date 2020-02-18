package de.testtask.service;

import de.testtask.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements SimpleRepository {

    List<User> userList = new ArrayList();

    @Override
    public void save(Object user) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Iterable<Object> findAll() {
        return null;
    }
}