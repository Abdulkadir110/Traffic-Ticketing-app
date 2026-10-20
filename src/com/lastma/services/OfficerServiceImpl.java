package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.reponses.FoundOfficerResponseDTO;
import com.lastma.dtos.reponses.RegisterOfficerResponseDTO;
import com.lastma.dtos.requests.RegisterOfficerRequest;

import static com.lastma.utils.Mappers.OfficerServiceMappers.map;
import static com.lastma.utils.Mappers.OfficerServiceMappers.mapFound;


class OfficerServiceImpl implements OfficerService {
    private final OfficerRepository officerRepository =  new OfficerRepositoryImpl();
    @Override
    public RegisterOfficerResponseDTO register(RegisterOfficerRequest request) {
        Officer savedOfficer = officerRepository.save(map(request));
        return map(savedOfficer);
    }

    @Override
    public FoundOfficerResponseDTO findOfficerById(int id) {
        return mapFound(officerRepository.findById(id));
    }
}