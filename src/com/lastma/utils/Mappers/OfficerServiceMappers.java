package com.lastma.utils.Mappers;

import com.lastma.data.models.Officer;
import com.lastma.dtos.reponses.FindOfficerResponses;
import com.lastma.dtos.requests.RegisterOfficerRequest;

public class OfficerServiceMappers {

    public static Officer map(RegisterOfficerRequest request) {
        Officer officer = new Officer();
        officer.setEmail(request.getEmail());
        officer.setPassword(request.getPassword());
        officer.setFullName(request.getFullName());
        return officer;
    }
    public static FindOfficerResponses map(Officer officer) {
        FindOfficerResponses response = new FindOfficerResponses();
        response.setEmail(officer.getEmail());
        response.setFullName(officer.getFullName());
        return response;
    }
}
