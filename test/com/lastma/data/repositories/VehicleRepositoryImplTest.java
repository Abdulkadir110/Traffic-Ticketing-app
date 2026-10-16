package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryImplTest {
    private VehicleRepositoryImpl vehicleRepository;

    @BeforeEach
    public void startWith() {
        vehicleRepository = new VehicleRepositoryImpl();
    }

    @Test
    public void saveAVehicle_countIsOne(){
        Vehicle vehicle = new Vehicle();
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
    }
    @Test
    public void saveTwoVehicles_countIsTwo(){
        Vehicle vehicle = new Vehicle();
        vehicleRepository.save(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicleRepository.save(vehicle2);
        assertEquals(2L,vehicleRepository.count());
    }
    @Test
    public void saveSameVehiclesTwice_countIsOne(){
        Vehicle vehicle = new Vehicle();
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
    }
}