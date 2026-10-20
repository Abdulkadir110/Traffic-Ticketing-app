package com.lastma.services;

import com.lastma.data.models.Ticket;
import com.lastma.data.repositories.TicketRepository;
import com.lastma.data.repositories.TicketRepositoryImpl;
import com.lastma.dtos.reponses.FoundTicketResponse;
import com.lastma.dtos.reponses.TicketIssuerResponse;
import com.lastma.dtos.requests.TicketIssueRequest;


import java.util.List;

import static com.lastma.utils.Mappers.TicketServiceMappers.*;

public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository = new TicketRepositoryImpl();
    @Override
    public TicketIssuerResponse issueTicket(TicketIssueRequest request) {
        Ticket issuedTicket = ticketRepository.save(mapTicketIssueRequest(request));
        return mapTicketIssueResponse(issuedTicket);
    }

    @Override
    public List<FoundTicketResponse> findVehicleTickets(String vehicleRegistrationNumber) {
        List<Ticket> tickets = ticketRepository.findTicketsBy(vehicleRegistrationNumber);
        for(Ticket ticket : ticketRepository.findAll()){
            if(ticket.getVehicleRegistrationNumber().equals(vehicleRegistrationNumber)){
                tickets.add(ticket);
            }
        }
        return mapVehicleTicket(tickets);
    }

}
