package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.List;

public interface TicketRepository {

    Ticket save(Ticket ticket);
    long count();

    Ticket findById(int id);

    void deleteById(int id);
    boolean existsById(int id);
    List<Ticket> findAll();
    void deleteAll();
}
