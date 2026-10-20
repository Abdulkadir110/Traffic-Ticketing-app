package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryImplTest {
    private VehicleRepositoryImpl vehicleRepository;
    private Vehicle vehicle;
    private String registrationNumber = "LRN563AD";
    @BeforeEach
    public void setUp() {
        vehicleRepository = new VehicleRepositoryImpl();
        vehicleRepository.deleteAll();
        vehicle = new Vehicle();
    }
    @Test
    public void saveVehicle_vehicleRepositoryCount_isOne() {
        assertEquals(0L, vehicleRepository.count());
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        assertEquals(1L, vehicleRepository.count());
    }
    @Test
    public void saveTwoVehicle_vehicleRepositoryCount_isTwo() {
        assertEquals(0L, vehicleRepository.count());
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicle.setRegistrationNumber("plateNumber");
        vehicleRepository.save(vehicle2);
        assertEquals(2L, vehicleRepository.count());
    }
    @Test
    public void save_NullVehicle_vehicleRepositoryCount_isZero(){
        vehicleRepository.save(null);
        assertEquals(0L, vehicleRepository.count());
    }
    @Test
    public void VehicleSaved_CanBeUpdated() {
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        vehicle.setRegistrationNumber("plateNumber");
        vehicleRepository.save(vehicle);
        assertEquals(1L, vehicleRepository.count());
    }
    @Test
    public void VehicleSaved_Updating_aNon_SavedVehicle_countIsOne() {
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicle.setRegistrationNumber("plateNumber");
        assertEquals(1L, vehicleRepository.count());
    }
    @Test
    public void saveTwoVehicle_findVehicleById_() {
        assertEquals(0L, vehicleRepository.count());
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber("plateNumber");
        vehicleRepository.save(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle2);
        Vehicle foundVehicle = vehicleRepository.findById(registrationNumber);
        assertSame(vehicle, foundVehicle);
    }
    @Test
    public void findNon_ExistingVehicle_ById_() {
        assertEquals(0L, vehicleRepository.count());
        assertNull(vehicleRepository.findById(registrationNumber));
    }
    @Test
    public void saveVehicle_checkIfvehicleExistById_() {
        assertEquals(0L, vehicleRepository.count());
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        assertTrue(vehicleRepository.existsById(registrationNumber));
    }
    @Test
    public void saveVehicle_checkIfVehicleExistByNonExisting_Id() {
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        assertFalse(vehicleRepository.existsById("plateNumber"));
    }
    @Test
    public void save2Vehicle_findTheTwoVehicle() {
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicle.setRegistrationNumber("plateNumber");
        vehicleRepository.save(vehicle2);
        assertEquals(2L, vehicleRepository.count());
        assertEquals(2,  vehicleRepository.findAll().size());
    }
    @Test
    public void save2Vehicle_DeleteOneVehicle() {
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        Vehicle vehicle2 = new Vehicle();
        vehicle.setRegistrationNumber("plateNumber");
        vehicleRepository.save(vehicle2);
        vehicleRepository.delete("plateNumber");
        assertEquals(1L, vehicleRepository.count());
    }
}