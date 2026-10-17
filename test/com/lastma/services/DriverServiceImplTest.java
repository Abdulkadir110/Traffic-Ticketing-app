package com.lastma.services;

import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceImplTest {
    private DriverService driverService;
    private DriverRepository driverRepository;
    @BeforeEach
    public void setup() {
        driverService = new DriverServiceImpl();
        driverRepository = new DriverRepositoryImpl();
        driverRepository.deleteAll();
    }
    @Test
    public void RegisterDriver_driverCountIsOne(){
        assertEquals(0L, driverRepository.count());
        driverService.register("full name", "email", "car plateNumber");
        assertEquals(1L, driverRepository.count());
    }
    @Test
    public void registerTwoDrivers_CountIsTwo(){
        assertEquals(0L, driverRepository.count());
        driverService.register("Opeyemi", "ope@gmail.com", "LRN567AS");
        driverService.register("Abdulkadir", "kadir@gmail.com", "PYT457DQ");
        assertEquals(2L, driverRepository.count());
    }

}