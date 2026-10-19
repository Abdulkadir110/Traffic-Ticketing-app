package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Ticket;
import com.lastma.data.models.ViolationType;
import com.lastma.dtos.reponses.FindOfficer;

import java.util.List;

public interface OfficerService {
    FindOfficer register(String fullName, String email, String password);


}
