package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Ticket;
import com.lastma.data.models.ViolationType;

import java.util.List;

public interface OfficerService {
    void register(String fullName, String email, String password);

    void issueTicket(int officerId, ViolationType type, Driver driver);

    List<Ticket> viewDriverTicket(int driverId);
}
