package com.lastma.services;

import com.lastma.data.models.VehicleType;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.data.repositories.VehicleRepository;
import com.lastma.data.repositories.VehicleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceImplTest {
    private DriverService driverService;
    private DriverRepository driverRepository;
    private VehicleRepository vehicleRepository;
    private String plateNumber = "LRN567AS";
    private String correctPassword = "password";
    @BeforeEach
    public void setup() {
        driverService = new DriverServiceImpl();
        driverRepository = new DriverRepositoryImpl();
        vehicleRepository = new VehicleRepositoryImpl();
        driverRepository.deleteAll();
        vehicleRepository.deleteAll();
    }
    @Test
    public void RegisterDriver_driverCountIsOne(){
        assertEquals(0L, driverRepository.count());
        driverService.register("full name", "email", "car plateNumber", correctPassword);
        assertEquals(1L, driverRepository.count());
    }
    @Test
    public void registerTwoDrivers_CountIsTwo(){
        assertEquals(0L, driverRepository.count());
        driverService.register("Opeyemi", "ope@gmail.com", plateNumber,correctPassword);
        driverService.register("Abdulkadir", "kadir@gmail.com", "PYT457DQ",correctPassword);
        assertEquals(2L, driverRepository.count());
    }
    @Test
    public void registeredDriver_registerVehicle_VehicleCountIsOne(){
        assertEquals(0L, driverRepository.count());
        driverService.register("Opeyemi", "ope@gmail.com", plateNumber, correctPassword);
        driverService.registerVehicle(1,"Toyota", "camry", VehicleType.CAR, Year.of(2025), plateNumber);
        assertEquals(1L, driverRepository.count());
        assertEquals(1L, vehicleRepository.count());
    }
    @Test
    public void registeredDriver_registerVehicleWithWrongDriverId_throwsException(){
        assertEquals(0L, driverRepository.count());
        driverService.register("Opeyemi", "ope@gmail.com", plateNumber, correctPassword);
        assertThrows(IllegalArgumentException.class, () -> driverService.registerVehicle(2,"Toyota", "camry", VehicleType.CAR, Year.of(2025), plateNumber));
        assertEquals(1L, driverRepository.count());
        assertEquals(0L, vehicleRepository.count());
    }

}