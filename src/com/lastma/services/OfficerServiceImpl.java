package com.lastma.services;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;
import com.lastma.data.models.Ticket;
import com.lastma.data.models.ViolationType;
import com.lastma.data.repositories.*;

import java.util.Date;
import java.util.List;

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
    public void issueTicket(int officerId, ViolationType type, Driver driver) {
        boolean isExist = validate(officerId);
        if (!isExist)throw new IllegalArgumentException("Officer with id " + officerId + " does not exist");
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
    @Override
    public List<Ticket> viewDriverTicket(int driverId) {
        Driver foundDriver = driverRepository.findById(driverId);
        validate(foundDriver);
        return foundDriver.getTickets();
    }

    private boolean validate(int officerId){
        for (Officer officer : officerRepository.findAll()) {
            if (officer.getId() == officerId) return true;
        }
        return false;
    }
    private void validate(Driver driver) {
        if(driver == null) throw new IllegalArgumentException("Driver does not exist");
    }
}
