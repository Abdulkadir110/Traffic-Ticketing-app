package com.lastma.services;

import com.lastma.data.models.ViolationType;
import com.lastma.data.repositories.OffenceRepository;
import com.lastma.data.repositories.OffenceRepositoryImpl;
import com.lastma.dtos.reponses.CreateOffenceResponseDTO;
import com.lastma.dtos.requests.CreateOffenceRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OffenceServiceImplTest {
    private OffenceService offenceService;
    private OffenceRepository offenceRepository;

    @BeforeEach
    public void setUp() {
        offenceRepository = new OffenceRepositoryImpl();
        offenceService = new OffenceServiceImpl();
    }
    @Test
    public void testThatWhenOffenceIsCreatedWithAType_itsRepositoryCountIsOne(){
        assertEquals(0L, offenceRepository.count());
        CreateOffenceRequestDTO offenceRequest = new CreateOffenceRequestDTO();
        offenceRequest.setCode("code");
        offenceRequest.setDescription("over-speeding");
        offenceRequest.setOffenceType(ViolationType.DRIVING_UNDER_INFLUENCE);
        CreateOffenceResponseDTO createdOffence = offenceService.createOffence(offenceRequest);
        assertEquals(1L, offenceRepository.count());
        assertEquals(createdOffence.getCode(),offenceRequest.getCode());
    }

}