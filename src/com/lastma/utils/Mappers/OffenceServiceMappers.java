package com.lastma.utils.Mappers;

import com.lastma.data.models.Offence;
import com.lastma.dtos.reponses.CreateOffenceResponseDTO;
import com.lastma.dtos.requests.CreateOffenceRequestDTO;

public class OffenceServiceMappers {
    public static Offence mapOffenceCreationRequest(CreateOffenceRequestDTO request) {
        Offence offence = new Offence(request.getOffenceType());
        offence.setDescription(request.getDescription());
        offence.setCode(request.getCode());
        offence.setFirstOffenceFine(offence.getFirstOffenceFine());
        return offence;
    }
    public static CreateOffenceResponseDTO mapOffenceCreationResponse(Offence offence) {
        CreateOffenceResponseDTO response = new CreateOffenceResponseDTO();
        response.setFirstOffenceFine(offence.getFirstOffenceFine());
        response.setCode(offence.getCode());
        response.setDescription(offence.getDescription());
        response.setOffenceId(offence.getId());
        return response;
    }
}
