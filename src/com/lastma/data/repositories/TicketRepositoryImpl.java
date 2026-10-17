package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    private int idCount;
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket ticket) {
        validate(ticket);
        if (existsById(ticket.getId())) {
            update(ticket);
            return ticket;
        }
        ticket.setId(++idCount);
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public long count() {
        return tickets.size();
    }

    @Override
    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        Ticket foundTicket = findById(id);
        tickets.remove(foundTicket);
    }

    @Override
    public boolean existsById(int id) {
        Ticket  foundTicket = findById(id);
        return foundTicket != null;
    }

    @Override
    public List<Ticket> findAll() {
        return List.copyOf(tickets);
    }

    @Override
    public void deleteAll() {
        tickets.clear();
    }

    private Ticket findTicket(Ticket ticket) {
        for (Ticket ticket2 : tickets) {
            if (ticket2.equals(ticket)) {
                return ticket;
            }
        }
        return null;
    }
    private void validate(Ticket ticket) {
        if (ticket == null) throw new IllegalArgumentException("The entity is null");
    }
    private void update(Ticket ticket) {
        Ticket  foundTicket = findTicket(ticket);
        if(foundTicket != null && foundTicket.getId() == ticket.getId()){
            tickets.set(tickets.indexOf(ticket), ticket);
        }
    }
}
