package com.lastma.utils.Mappers;

import com.lastma.data.models.Officer;
import com.lastma.dtos.reponses.FoundOfficerResponseDTO;
import com.lastma.dtos.reponses.RegisterOfficerResponseDTO;
import com.lastma.dtos.requests.RegisterOfficerRequest;

public class OfficerServiceMappers {

    public static Officer map(RegisterOfficerRequest request) {
        Officer officer = new Officer();
        officer.setEmail(request.getEmail());
        officer.setPassword(request.getPassword());
        officer.setFullName(request.getFullName());
        return officer;
    }
    public static RegisterOfficerResponseDTO map(Officer officer) {
        RegisterOfficerResponseDTO response = new RegisterOfficerResponseDTO();
        response.setEmail(officer.getEmail());
        response.setFullName(officer.getFullName());
        response.setId(officer.getId());
        return response;
    }

    public static FoundOfficerResponseDTO mapFound(Officer officer) {
        FoundOfficerResponseDTO response = new FoundOfficerResponseDTO();
        response.setEmail(officer.getEmail());
        response.setFullName(officer.getFullName());
        response.setId(officer.getId());
        return response;
    }
}
