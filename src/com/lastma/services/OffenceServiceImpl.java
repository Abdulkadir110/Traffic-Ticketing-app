package com.lastma.services;


import com.lastma.data.models.Offence;
import com.lastma.dtos.reponses.CreateOffenceResponseDTO;
import com.lastma.dtos.requests.CreateOffenceRequestDTO;

import static com.lastma.utils.Mappers.OffenceServiceMappers.mapOffenceCreationRequest;
import static com.lastma.utils.Mappers.OffenceServiceMappers.mapOffenceCreationResponse;

public class OffenceServiceImpl implements OffenceService {

    @Override
    public CreateOffenceResponseDTO createOffence(CreateOffenceRequestDTO request) {
        Offence createdOffence = mapOffenceCreationRequest(request);
        return mapOffenceCreationResponse(createdOffence);
    }
}
