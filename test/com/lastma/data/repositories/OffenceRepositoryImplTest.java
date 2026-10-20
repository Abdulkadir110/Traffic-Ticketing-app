package com.lastma.data.repositories;

import com.lastma.data.models.Offence;
import com.lastma.data.models.ViolationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OffenceRepositoryImplTest {
    private OffenceRepositoryImpl offenceRepository;
    @BeforeEach
    public void setUp() {
        offenceRepository = new OffenceRepositoryImpl();
        offenceRepository.deleteAll();
    }
    @Test
    public void saveOffence_offenceRepositoryCount_isOne() {
        assertEquals(0L, offenceRepository.count());
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        assertEquals(1L, offenceRepository.count());
    }
    @Test
    public void saveTwoOffence_offenceRepositoryCount_isTwo() {
        assertEquals(0L, offenceRepository.count());
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        Offence offence2 = new Offence(ViolationType.ILLEGAL_U_TURN);
        offenceRepository.save(offence2);
        assertEquals(2L, offenceRepository.count());
    }
    @Test
    public void OffenceSaved_CanBeUpdated() {
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        offence.setType(ViolationType.ILLEGAL_U_TURN);
        offenceRepository.save(offence);
        assertEquals(1L, offenceRepository.count());
    }
    @Test
    public void OffenceSaved_Updating_aNon_SavedOffence_countIsOne() {
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        Offence offence2 = new Offence(ViolationType.ILLEGAL_U_TURN);
        assertEquals(1L, offenceRepository.count());
    }
    @Test
    public void saveTwoOffence_findOffenceById_() {
        assertEquals(0L, offenceRepository.count());
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        Offence savedOffence = offenceRepository.save(offence);
        Offence offence2 = new Offence(ViolationType.ILLEGAL_U_TURN);
        offenceRepository.save(offence2);
        Offence foundOffence = offenceRepository.findById(1);
        assertSame(savedOffence, foundOffence);
    }
    @Test
    public void findNon_ExistingOffence_ById_() {
        assertEquals(0L, offenceRepository.count());
        assertNull(offenceRepository.findById(1));
    }
    @Test
    public void saveOffence_checkIfOffenceExistById_() {
        assertEquals(0L, offenceRepository.count());
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        assertTrue(offenceRepository.existsById(1));
    }
    @Test
    public void saveOffence_checkIfOffenceExistByNonExisting_Id() {
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        assertFalse(offenceRepository.existsById(2));
    }
    @Test
    public void save2Offence_findTheTwoOffence() {
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        Offence offence2 = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence2);
        assertEquals(2L, offenceRepository.count());
        assertEquals(2,  offenceRepository.findAll().size());
    }
    @Test
    public void save2Offence_DeleteOneOffence() {
        Offence offence = new Offence(ViolationType.BRT_LANE_VIOLATION);
        offenceRepository.save(offence);
        Offence offence2 = new Offence(ViolationType.ILLEGAL_U_TURN);
        offenceRepository.save(offence2);
        offenceRepository.deleteById(2);
        assertEquals(1L, offenceRepository.count());
    }
    @Test
    public void nullOffence_cantBeSaved_returnsNull(){
        assertEquals(0L, offenceRepository.count());
        Offence savedOffence = offenceRepository.save(null);
        assertEquals(0L, offenceRepository.count());
        assertNull(savedOffence);
    }
}