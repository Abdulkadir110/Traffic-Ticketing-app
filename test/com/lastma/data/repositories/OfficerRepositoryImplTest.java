package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerRepositoryImplTest {
    private OfficerRepositoryImpl officerRepositoryImpl;
    @BeforeEach
    public void startWith() {
        officerRepositoryImpl = new OfficerRepositoryImpl();
    }
    @Test
    public void saveOfficer_countIsOne(){
        Officer officer = new Officer();
        officerRepositoryImpl.save(officer);
        assertEquals(1L, officerRepositoryImpl.count());
    }

}