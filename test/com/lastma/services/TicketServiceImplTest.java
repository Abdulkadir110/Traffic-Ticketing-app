package com.lastma.services;

import com.lastma.data.repositories.TicketRepository;
import com.lastma.data.repositories.TicketRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceImplTest {
    private TicketService ticketService;
    private TicketRepository ticketRepository;
    @BeforeEach
    public void setup() {
        ticketService = new TicketServiceImpl();
        ticketRepository = new TicketRepositoryImpl();
    }
//    @Test
//    public void issueATicket_repositoryCount_isOne() {
//        ticketService.issueTicket("plateNumber", O)
//    }

}