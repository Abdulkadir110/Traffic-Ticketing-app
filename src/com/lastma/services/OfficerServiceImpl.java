package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.reponses.FindOfficerResponses;

class OfficerServiceImpl implements OfficerService {
    private final OfficerRepository officerRepository =  new OfficerRepositoryImpl();
    @Override
    public FindOfficerResponses register(String fullName, String email, String password) {
        Officer officer = new Officer();
        officer.setFullName(fullName);
        officer.setEmail(email);
        officer.setPassword(password);
        Officer savedOfficer = officerRepository.save(officer);
        FindOfficerResponses findOfficer = new FindOfficerResponses();
        findOfficer.setFullName(savedOfficer.getFullName());
        findOfficer.setEmail(savedOfficer.getEmail());
        return findOfficer;
    }
}