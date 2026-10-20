package com.lastma.services;

import com.lastma.data.models.PaymentStatus;
import com.lastma.data.models.ViolationType;
import com.lastma.data.repositories.TicketRepository;
import com.lastma.data.repositories.TicketRepositoryImpl;
import com.lastma.dtos.reponses.CreateOffenceResponseDTO;
import com.lastma.dtos.reponses.RegisterVehicleResponse;
import com.lastma.dtos.reponses.TicketIssuerResponse;
import com.lastma.dtos.requests.CreateOffenceRequestDTO;
import com.lastma.dtos.requests.RegisterVehicleRequest;
import com.lastma.dtos.requests.TicketIssueRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceImplTest {
    private TicketService ticketService;
    private TicketRepository ticketRepository;
    private VehicleService  vehicleService;
    private OffenceService offenceService;
    @BeforeEach
    public void setup() {
        ticketService = new TicketServiceImpl();
        ticketRepository = new TicketRepositoryImpl();
        vehicleService = new VehicleServiceImpl();
        offenceService = new OffenceServiceImpl();
    }
    @Test
    public void issueATicket_repositoryCount_isOne_VehicleId_InTicket_isEqualToRegisteredVehicleRegNumber() {
        assertEquals(0L, ticketRepository.count());
        TicketIssueRequest request = new TicketIssueRequest();
        RegisterVehicleRequest vehicleRequest = new RegisterVehicleRequest();
        vehicleRequest.setRegistrationNumber("LRN001");
        vehicleRequest.setMake("Toyota");
        vehicleRequest.setModel("Corolla");
        vehicleRequest.setColor("Red");
        RegisterVehicleResponse registeredVehicle = vehicleService.registerVehicle(vehicleRequest);
        request.setVehicleId(registeredVehicle.getRegistrationNumber());
        CreateOffenceRequestDTO offenceRequest = new CreateOffenceRequestDTO();
        offenceRequest.setCode("A101");
        offenceRequest.setDescription("Parked on a walkway");
        offenceRequest.setOffenceType(ViolationType.PARKING_ON_WALKWAY);
        CreateOffenceResponseDTO createdOffence = offenceService.createOffence(offenceRequest);
        request.setOffenceId(createdOffence.getOffenceId());
        TicketIssuerResponse issuedTicket = ticketService.issueTicket(request);
        assertEquals(1L, ticketRepository.count());
        assertEquals(issuedTicket.getOffenceId(), createdOffence.getOffenceId());
        assertEquals(issuedTicket.getVehicleId(), registeredVehicle.getRegistrationNumber());
        assertEquals(PaymentStatus.UNPAID, issuedTicket.getPaymentStatus());
    }


}