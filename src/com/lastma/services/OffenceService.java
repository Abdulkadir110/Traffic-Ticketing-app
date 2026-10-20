package com.lastma.services;

import com.lastma.data.models.ViolationType;
import com.lastma.dtos.reponses.CreateOffenceResponseDTO;
import com.lastma.dtos.reponses.FindOffenceResponses;
import com.lastma.dtos.requests.CreateOffenceRequestDTO;

public interface OffenceService {
    CreateOffenceResponseDTO createOffence(CreateOffenceRequestDTO request);
}
