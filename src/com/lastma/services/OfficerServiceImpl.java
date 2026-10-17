package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;
import com.lastma.data.models.Ticket;
import com.lastma.data.models.ViolationType;
import com.lastma.data.repositories.*;

import java.util.Date;

public class OfficerServiceImpl implements OfficerService {
    private OfficerRepository officerRepository = new OfficerRepositoryImpl();
    private DriverRepository driverRepository = new DriverRepositoryImpl();
    private TicketRepository ticketRepository = new TicketRepositoryImpl();
    @Override
    public void register(String fullName, String email, String password) {
        Officer officer = new Officer();
        officer.setFullName(fullName);
        officer.setEmail(email);
        officer.setPassword(password);
        officerRepository.save(officer);
    }

    @Override
    public void issueTicket(ViolationType type, Driver driver) {
        driverRepository.save(driver);
        Ticket ticket = new Ticket();
        ticket.setType(type);
        ticket.setViolationFee(type.getFee());
        Date now = new Date();
        ticket.setIssuedDate(now);
        ticket.setDueDate(new Date(ticket.getIssuedDate().getTime() + 5L * 24 * 60 * 60 * 1000));
        driver.getTickets().add(ticket);
        ticketRepository.save(ticket);
    }
}
