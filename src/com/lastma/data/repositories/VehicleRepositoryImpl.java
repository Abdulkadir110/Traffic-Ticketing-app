package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private static List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public long count() {
        return vehicles.size();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (vehicle == null) return null;
        if (existsById(vehicle.getRegistrationNumber())) {
            update(vehicle);
            return vehicle;
        }
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(String registrationNumber) {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getRegistrationNumber().equals(registrationNumber)){
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public void delete(String registrationNumber) {
        Vehicle foundVehicle = findById(registrationNumber);
        vehicles.remove(foundVehicle);
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public boolean existsById(String registrationNumber) {
        Vehicle foundVehicle = findById(registrationNumber);
        return foundVehicle != null;
    }


    @Override
    public List<Vehicle> findAll() {
        return List.copyOf(vehicles);
    }
    private void update(Vehicle vehicle) {
        vehicles.set(vehicles.indexOf(vehicle), vehicle);
    }
}