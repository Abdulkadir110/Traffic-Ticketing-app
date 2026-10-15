package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    private int count;
    private int idCount;
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket ticket) {
        Date todayDate = new Date();
        tickets.add(ticket);
        ticket.setId(++idCount);
        ticket.setIssuedDate(todayDate);
        count++;
        return ticket;
    }

    @Override
    public long count() {
        return count;
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
    public void delete(Ticket ticket) {
        Ticket foundTicket = findTicket(ticket);
        tickets.remove(foundTicket);
        count--;
    }

    @Override
    public void deleteById(int id) {
        Ticket foundTicket = findById(id);
        tickets.remove(foundTicket);
        count--;
    }

    private Ticket findTicket(Ticket ticket) {
        for (Ticket ticket2 : tickets) {
            if (ticket2.equals(ticket)) {
                return ticket;
            }
        }
        return null;
    }
}
