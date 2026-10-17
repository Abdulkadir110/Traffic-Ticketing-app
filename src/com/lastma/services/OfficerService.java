package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.ViolationType;

public interface OfficerService {
    void register(String fullName, String email, String password);

    void issueTicket(ViolationType type, Driver driver);
}
