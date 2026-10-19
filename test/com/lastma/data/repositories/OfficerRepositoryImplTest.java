package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerRepositoryImplTest {
    private OfficerRepositoryImpl officerRepository;
    private Officer officer;
    @BeforeEach
    public void setUp() {
        officerRepository = new OfficerRepositoryImpl();
        officerRepository.deleteAll();
        officer = new Officer();
    }
    @Test
    public void saveOfficer_OfficerRepositoryCount_isOne() {
        assertEquals(0L, officerRepository.count());
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        assertEquals(1L, officerRepository.count());
    }
    @Test
    public void saveTwoOfficer_OfficerRepositoryCount_isTwo() {
        assertEquals(0L, officerRepository.count());
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        Officer officer2 = new Officer();
        officer2.setFullName("Opeyemi");
        officer2.setEmail("ope@gmail.com");
        officerRepository.save(officer2);
        assertEquals(2L, officerRepository.count());
    }
    @Test
    public void save_nullOfficer_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> officerRepository.save(null));
    }
    @Test
    public void OfficerSaved_CanBeUpdated() {
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        officer.setFullName("Opeyemi");
        officer.setEmail("ope@gmail.com");
        officerRepository.save(officer);
        assertEquals(1L, officerRepository.count());
    }
    @Test
    public void OfficerSaved_Updating_aNon_SavedOfficer_countIsOne() {
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        Officer officer2 = new Officer();
        officer2.setFullName("Opeyemi");
        assertEquals(1L, officerRepository.count());
    }
    @Test
    public void saveTwoOfficer_findOfficerById_() {
        assertEquals(0L, officerRepository.count());
        Officer officer = new Officer();
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        Officer officer2 = new Officer();
        officer2.setFullName("Opeyemi");
        officer2.setEmail("ope@gmail.com");
        officerRepository.save(officer2);
        Officer foundOfficer = officerRepository.findById(1);
        assertSame(officer, foundOfficer);
    }
    @Test
    public void findNon_ExistingOfficer_ById_() {
        assertEquals(0L, officerRepository.count());
        assertNull(officerRepository.findById(1));
    }
    @Test
    public void saveOfficer_checkIfofficerExistById_() {
        assertEquals(0L, officerRepository.count());
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        assertTrue(officerRepository.existsById(1));
    }
    @Test
    public void saveOfficer_checkIfOfficerExistByNonExisting_Id() {
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        assertFalse(officerRepository.existsById(2));
    }
    @Test
    public void save2Officer_findTheTwoOfficer() {
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        Officer officer2 = new Officer();
        officer2.setFullName("Opeyemi");
        officer2.setEmail("ope@gmail.com");
        officerRepository.save(officer2);
        assertEquals(2L, officerRepository.count());
        assertEquals(2,  officerRepository.findAll().size());
    }
    @Test
    public void save2Officer_DeleteOneOfficer() {
        Officer officer = new Officer();
        officer.setFullName("Abdulkadir");
        officer.setEmail("kadir@gmail.com");
        officerRepository.save(officer);
        Officer officer2 = new Officer();
        officer2.setFullName("Opeyemi");
        officer2.setEmail("ope@gmail.com");
        officerRepository.save(officer2);
        officerRepository.deleteById(2);
        assertEquals(1L, officerRepository.count());
    }
}