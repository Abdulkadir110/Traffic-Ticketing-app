package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    private int idcount;
    private static List<Ticket> tickets = new ArrayList<>();
    @Override
    public long count() {
        return tickets.size();
    }

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket == null) return null;
        if (existsById(ticket.getId())) {
            update(ticket);
            return ticket;
        }
        ticket.setId(++idcount);
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
        return findTicket(id);
    }

    @Override
    public void deleteById(int id) {
        Ticket foundTicket = findTicket(id);
        tickets.remove(foundTicket);
    }

    @Override
    public void deleteAll() {
        tickets.clear();
    }

    @Override
    public List<Ticket> findTicketsBy(String vehicleRegNumber) {
        List<Ticket> foundTickets = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getVehicleRegistrationNumber().equals(vehicleRegNumber)) {
                foundTickets.add(ticket);
            }
        }
        return foundTickets;
    }

    @Override
    public List<Ticket> findAll() {
        return List.copyOf(tickets);
    }

    @Override
    public boolean existsById(int id) {
        Ticket foundTicket = findById(id);
        return foundTicket != null;
    }

    private Ticket findTicket(int id){
        for(Ticket ticket : tickets){
            if(ticket.getId() == id){
                return ticket;
            }
        }
        return null;
    }
    private void update(Ticket ticket) {
        tickets.set(tickets.indexOf(ticket), ticket);
    }
}
