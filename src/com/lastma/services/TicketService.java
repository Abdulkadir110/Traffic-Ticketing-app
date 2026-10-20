package com.lastma.services;

import com.lastma.dtos.reponses.FoundTicketResponse;
import com.lastma.dtos.reponses.TicketIssuerResponse;
import com.lastma.dtos.requests.TicketIssueRequest;

import java.util.List;

public interface TicketService {
    TicketIssuerResponse issueTicket(TicketIssueRequest request);
    List<FoundTicketResponse> findVehicleTickets(String vehicleRegistrationNumber);
}
