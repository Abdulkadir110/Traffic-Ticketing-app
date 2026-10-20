package com.lastma.services;

import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import com.lastma.dtos.reponses.FoundDriverResponseDTO;
import com.lastma.dtos.reponses.RegisterDriverResponseDTO;
import com.lastma.dtos.requests.RegisterDriverRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
        RegisterDriverRequestDTO request = new RegisterDriverRequestDTO();
        request.setEmail("email");
        request.setPhoneNumber("phone");
        request.setFullName("full name");
        request.setPassword(correctPassword);
        driverService.register(request);
        assertEquals(1L, driverRepository.count());
    }
    @Test
    public void register_TwoDrivers_driverRepository_count_isTwo() {
        assertEquals(0L, driverRepository.count());
        RegisterDriverRequestDTO request = new RegisterDriverRequestDTO();
        request.setEmail("email");
        request.setPhoneNumber("phone");
        request.setFullName("full name");
        request.setPassword(correctPassword);
        driverService.register(request);
        RegisterDriverRequestDTO request2 = new RegisterDriverRequestDTO();
        request2.setEmail("ope@gmail.com");
        request2.setPhoneNumber("09918772");
        request2.setFullName("ope");
        request2.setPassword("password");
        driverService.register(request2);
        assertEquals(2L, driverRepository.count());
    }
    @Test
    public void registerDriver_getRegisteredDriverDetails_inTheRepository(){
        RegisterDriverRequestDTO request = new RegisterDriverRequestDTO();
        request.setEmail("kadir@gmail.com");
        request.setPhoneNumber("08123456789");
        request.setFullName("Abdulkadir");
        request.setPassword(correctPassword);
        RegisterDriverResponseDTO registeredDriver = driverService.register(request);
        assertEquals(1L, driverRepository.count());
        assertEquals("Abdulkadir", registeredDriver.getFullName());
        assertEquals("kadir@gmail.com", registeredDriver.getEmail());
        assertEquals("08123456789", registeredDriver.getPhoneNumber());
    }
    @Test
    public void registerDriver_findDriverById(){
        RegisterDriverRequestDTO request = new RegisterDriverRequestDTO();
        request.setEmail("08123456789");
        request.setPhoneNumber("08123456789");
        request.setFullName("Abdulkadir");
        request.setPassword(correctPassword);
        RegisterDriverResponseDTO registeredDriver = driverService.register(request);
        FoundDriverResponseDTO foundDriver = driverService.findDriverById(1);
        assertEquals(registeredDriver.getFullName(), foundDriver.getFullName());
        assertEquals(registeredDriver.getEmail(), foundDriver.getEmail());
        assertEquals(registeredDriver.getPhoneNumber(), foundDriver.getPhoneNumber());
    }
    @Test
    public void findNon_ExistingDriver_throwsException() {
        assertThrows(IllegalArgumentException.class, ()-> driverService.findDriverById(1));
        assertEquals(0L, driverRepository.count());
    }

}