package de.testtask.service;

public interface SimpleRepository {

    void save(Object user);

    void deleteById(long id);

    Iterable<Object> findAll();
}