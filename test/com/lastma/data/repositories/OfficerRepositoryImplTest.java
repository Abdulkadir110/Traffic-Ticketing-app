package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerRepositoryImplTest {
    private OfficerRepositoryImpl officerRepositoryImpl;
    private Officer officer;
    @BeforeEach
    public void startWith() {
        officerRepositoryImpl = new OfficerRepositoryImpl();
        officer = new Officer();
    }
    @Test
    public void saveOfficer_countIsOne(){
        officerRepositoryImpl.save(officer);
        assertEquals(1L, officerRepositoryImpl.count());
    }
    @Test
    public void saveTwoOfficers_countIsTwo(){
        officerRepositoryImpl.save(officer);
        Officer officer2 = new Officer();
        officerRepositoryImpl.save(officer2);
        assertEquals(2L, officerRepositoryImpl.count());
    }
    @Test
    public void saveOfficer_findOfficerById(){
        officer.setFullName("John Doe");
        officer.setEmail("johnDoe@gmail.com");
        Officer savedOfficer = officerRepositoryImpl.save(officer);
        assertEquals(savedOfficer, officerRepositoryImpl.findById(1));
    }
    @Test
    public void saveTwoOfficers_deleteOfficerById(){
        officer.setFullName("John Doe");
        officerRepositoryImpl.save(officer);
        Officer officer2 = new Officer();
        officer2.setFullName("John James");
        officerRepositoryImpl.save(officer2);
        officerRepositoryImpl.deleteById(1);
        assertEquals(1L, officerRepositoryImpl.count());
    }
    @Test
    public void saveTwoOfficers_deleteOfficerEntity(){
        officer.setFullName("John Doe");
        officerRepositoryImpl.save(officer);
        Officer officer2 = new Officer();
        officer2.setFullName("John James");
        officerRepositoryImpl.save(officer2);
        officerRepositoryImpl.delete(officer);
        assertEquals(1L, officerRepositoryImpl.count());
    }
}