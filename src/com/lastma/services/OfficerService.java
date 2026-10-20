package com.lastma.services;

import com.lastma.dtos.reponses.FindOfficerResponses;
import com.lastma.dtos.requests.RegisterOfficerRequest;

public interface OfficerService {
    FindOfficerResponses register(RegisterOfficerRequest request);


}
