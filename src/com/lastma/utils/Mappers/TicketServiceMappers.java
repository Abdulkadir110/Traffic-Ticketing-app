package com.lastma.utils.Mappers;

import com.lastma.data.models.PaymentStatus;
import com.lastma.data.models.Ticket;
import com.lastma.dtos.reponses.FoundTicketResponse;
import com.lastma.dtos.reponses.TicketIssuerResponse;
import com.lastma.dtos.requests.TicketIssueRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketServiceMappers {
    public static Ticket mapTicketIssueRequest(TicketIssueRequest request) {
        Ticket ticket = new Ticket();
        ticket.setVehicleRegistrationNumber(request.getVehicleId());
        ticket.setDescription(request.getDescription());
        ticket.setLocation(request.getLocation());
        ticket.setIncidentDateTime(request.getIncidentDateTime());
        ticket.setPaymentStatus(PaymentStatus.UNPAID);
        ticket.setIssuedAt(new Date());
        return ticket;
    }
    public static TicketIssuerResponse mapTicketIssueResponse(Ticket ticket) {
        TicketIssuerResponse response = new TicketIssuerResponse();
        response.setDescription(ticket.getDescription());
        response.setLocation(ticket.getLocation());
        response.setIncidentDateTime(ticket.getIncidentDateTime());
        response.setVehicleId(ticket.getVehicleRegistrationNumber());
        response.setIssuedAt(ticket.getIssuedAt());
        response.setPaymentStatus(ticket.getPaymentStatus());
        return response;
    }
    public static List<FoundTicketResponse> mapVehicleTicket(List<Ticket> tickets) {
        List<FoundTicketResponse> responses = new ArrayList<>();
        for (Ticket ticket : tickets) {
            FoundTicketResponse response = new FoundTicketResponse();
            response.setTicketNumber(ticket.getTicketNumber());
            response.setVehicleRegistrationNumber(ticket.getVehicleRegistrationNumber());
            response.setLocation(ticket.getLocation());
            response.setAccessedFine(ticket.getAccessedFine());
            response.setIssuedAt(ticket.getIssuedAt());

            responses.add(response);
        }
        return responses;
    }
}
