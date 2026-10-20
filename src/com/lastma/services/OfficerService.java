package com.lastma.services;

import com.lastma.dtos.reponses.FindOfficerResponses;

public interface OfficerService {
    FindOfficerResponses register(String fullName, String email, String password);


}
