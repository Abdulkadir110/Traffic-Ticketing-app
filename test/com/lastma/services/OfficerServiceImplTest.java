package com.lastma.services;

import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.reponses.FindOfficerResponses;
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
        officerService.register("full name", "email", "password");
        assertEquals(1L, officerRepository.count());
    }
    @Test
    public void registerOfficer_OfficerRepositoryCount_IsOne_getRegisteredOfficerDetails(){
        assertEquals(0L, officerRepository.count());
        FindOfficerResponses registeredOfficer = officerService.register("Abdulkadir", "abdul@gmail.com", password);
        assertEquals(1L, officerRepository.count());
        assertEquals("Abdulkadir", registeredOfficer.getFullName());
        assertEquals("abdul@gmail.com", registeredOfficer.getEmail());
    }
}