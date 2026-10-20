package com.lastma.services;

import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.dtos.reponses.FindDriverResponses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DriverServiceImplTest {
    private DriverService driverService;
    private DriverRepository driverRepository;
    private String correctPassword = "1111";
    @BeforeEach
    public void setup() {
        driverService = new DriverServiceImpl();
        driverRepository = new DriverRepositoryImpl();
        driverRepository.deleteAll();
    }
    @Test
    public void register_ADriver_driverRepository_count_isOne() {
        assertEquals(0L, driverRepository.count());
        driverService.register("full name", "email", "phone number", "password");
        assertEquals(1L, driverRepository.count());
    }
    @Test
    public void register_TwoDrivers_driverRepository_count_isTwo() {
        assertEquals(0L, driverRepository.count());
        driverService.register("Abdulkadir", "kadir@gmail.com", "08123456789",correctPassword);
        driverService.register("Opeyemi", "ope@gmail.com", "09123456789",correctPassword);
        assertEquals(2L, driverRepository.count());
    }
    @Test
    public void registerDriver_getRegisteredDriverDetails_inTheRepository(){
        FindDriverResponses registeredDriver = driverService.register("Abdulkadir", "kadir@gmail.com", "08123456789",correctPassword);
        assertEquals(1L, driverRepository.count());
        assertEquals("Abdulkadir", registeredDriver.getFullName());
        assertEquals("kadir@gmail.com", registeredDriver.getEmail());
        assertEquals("08123456789", registeredDriver.getPhoneNumber());
    }
    @Test
    public void registerDriver_findDriverById(){
        FindDriverResponses registeredDriver = driverService.register("Abdulkadir", "kadir@gmail.com", "08123456789",correctPassword);
        FindDriverResponses foundDriver = driverService.findById(1);
        assertEquals(registeredDriver.getFullName(), foundDriver.getFullName());
        assertEquals(registeredDriver.getEmail(), foundDriver.getEmail());
        assertEquals(registeredDriver.getPhoneNumber(), foundDriver.getPhoneNumber());
    }

}