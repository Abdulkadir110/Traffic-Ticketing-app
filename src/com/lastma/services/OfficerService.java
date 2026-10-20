package com.lastma.services;

import com.lastma.dtos.reponses.FoundOfficerResponseDTO;
import com.lastma.dtos.reponses.RegisterOfficerResponseDTO;
import com.lastma.dtos.requests.RegisterOfficerRequest;

public interface OfficerService {
    RegisterOfficerResponseDTO register(RegisterOfficerRequest request);


    FoundOfficerResponseDTO findOfficerById(int id);
}
