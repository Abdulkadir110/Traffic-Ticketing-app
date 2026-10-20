package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.reponses.FindOfficerResponses;
import com.lastma.dtos.requests.RegisterOfficerRequest;

import static com.lastma.utils.Mappers.OfficerServiceMappers.map;


class OfficerServiceImpl implements OfficerService {
    private final OfficerRepository officerRepository =  new OfficerRepositoryImpl();
    @Override
    public FindOfficerResponses register(RegisterOfficerRequest request) {
        Officer savedOfficer = officerRepository.save(map(request));
        return map(savedOfficer);
    }
}