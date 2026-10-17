package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.List;

public interface DriverRepository {
    long count();
    Driver save(Driver driver);
    Driver findById(int id);
    void deleteById(int id);
    void deleteAll();
    List<Driver> findAll();
    boolean existsById(int id);
}
