package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryImplTest {
    private VehicleRepositoryImpl vehicleRepository;
    private Vehicle vehicle;
    private String correctPlateNumber = "LRB2494AD";
    @BeforeEach
    public void startWith() {
        vehicleRepository = new VehicleRepositoryImpl();
        vehicle = new Vehicle();
        vehicleRepository.deleteAll();
    }

    @Test
    public void saveAVehicle_countIsOne(){
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
    }
    @Test
    public void saveTwoVehicles_countIsTwo(){
        vehicle.setCarPlateNumber("LRB2494YH");
        vehicleRepository.save(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setCarPlateNumber(correctPlateNumber);
        vehicleRepository.save(vehicle2);
        assertEquals(2L,vehicleRepository.count());
    }
    @Test
    public void saveSameVehiclesTwice_countIsOne(){
        vehicle.setCarPlateNumber(correctPlateNumber);
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
        vehicle.setCarPlateNumber("BRN817DS");
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
    }
    @Test
    public void saveVehicle_checkIfExists(){
        vehicle.setCarPlateNumber(correctPlateNumber);
        vehicleRepository.save(vehicle);
        assertEquals(1L,vehicleRepository.count());
        assertTrue(vehicleRepository.existsById(correctPlateNumber));
        assertFalse(vehicleRepository.existsById("BRN817DS"));
    }
}