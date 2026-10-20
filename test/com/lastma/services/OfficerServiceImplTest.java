package com.lastma.services;

import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.reponses.FindOfficerResponses;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfficerServiceImplTest {
    private OfficerServiceImpl officerService;
    private OfficerRepository officerRepository;
    private String password = "1111";

    @BeforeEach
    public void setUp() {
        officerService = new OfficerServiceImpl();
        officerRepository = new OfficerRepositoryImpl();
        officerRepository.deleteAll();
    }
    @Test
    public void registerOfficer_OfficerRepositoryCount_IsOne(){
        assertEquals(0L, officerRepository.count());
        RegisterOfficerRequest request = new RegisterOfficerRequest();
        request.setFullName("full name");
        request.setEmail("email");
        request.setPassword("password");
        officerService.register(request);
        assertEquals(1L, officerRepository.count());
    }
    @Test
    public void registerOfficer_OfficerRepositoryCount_IsOne_getRegisteredOfficerDetails(){
        assertEquals(0L, officerRepository.count());
        RegisterOfficerRequest request = new RegisterOfficerRequest();
        request.setFullName("Abdulkadir");
        request.setEmail("abdul@gmail.com");
        request.setPassword(password);
        FindOfficerResponses registeredOfficer = officerService.register(request);
        assertEquals(1L, officerRepository.count());
        assertEquals("Abdulkadir", registeredOfficer.getFullName());
        assertEquals("abdul@gmail.com", registeredOfficer.getEmail());
    }
}