package com.lastma.data.repositories;


import com.lastma.data.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    long count();

    Vehicle save(Vehicle vehicle);

    Vehicle findById(String registrationNumber);

    void delete(String registrationNumber);

    void deleteAll();

    boolean existsById(String registrationNumber);

    List<Vehicle> findAll();
}