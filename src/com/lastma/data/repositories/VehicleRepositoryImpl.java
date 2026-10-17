package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;
import com.lastma.data.models.Ticket;
import com.lastma.data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public long count() {
        return vehicles.size();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (existsById(vehicle.getCarPlateNumber())) {
            update(vehicle);
            return vehicle;
        }
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(String plateNumber) {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getCarPlateNumber().equals(plateNumber)){
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public void delete(String plateNumber) {
        Vehicle foundVehicle = findById(plateNumber);
        vehicles.remove(foundVehicle);
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public boolean existsById(String plateNumber) {
        Vehicle foundVehicle = findById(plateNumber);
        return foundVehicle != null;
    }

    @Override
    public List<Vehicle> findAll() {
        return List.copyOf(vehicles);
    }

    private void validate(Vehicle vehicle){
        if(vehicle == null) throw new IllegalArgumentException("The entity is null");
    }
    private Vehicle findByVehicle(Vehicle givenVehicle){
        for(Vehicle vehicle : vehicles){
            if(vehicle.equals(givenVehicle))return vehicle;
        }
        return null;
    }
    private void update(Vehicle vehicle) {
        Vehicle  foundVehicle = findByVehicle(vehicle);
        if(foundVehicle != null && foundVehicle.getCarPlateNumber().equals(vehicle.getCarPlateNumber())){
            vehicles.set(vehicles.indexOf(vehicle), vehicle);
        }
    }
}