package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
    private int numberOfVehicles;

    @Override
    public long count() {
        return numberOfVehicles;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        numberOfVehicles++;
        return vehicle;
    }
}
