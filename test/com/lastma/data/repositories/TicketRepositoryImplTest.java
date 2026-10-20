package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryImplTest {

    private TicketRepositoryImpl ticketRepository;
    private Ticket ticket;
    @BeforeEach
    public void setUp() {
        ticketRepository = new TicketRepositoryImpl();
        ticketRepository.deleteAll();
        ticket = new Ticket();
    }
    @Test
    public void saveTicket_ticketRepositoryCount_isOne() {
        assertEquals(0L, ticketRepository.count());
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        assertEquals(1L, ticketRepository.count());
    }
    @Test
    public void saveTwoTicket_TicketRepositoryCount_isTwo() {
        assertEquals(0L, ticketRepository.count());
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        Ticket ticket2 = new Ticket();
        ticket.setDescription("Test ticket2");
        ticketRepository.save(ticket2);
        assertEquals(2L, ticketRepository.count());
    }
    @Test
    public void save_NullObject_ticketRepositoryCount_isZero() {
        ticketRepository.save(null);
        assertEquals(0L, ticketRepository.count());
    }
    @Test
    public void TicketSaved_CanBeUpdated() {
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        ticket.setDescription("Test ticket --updated");
        ticketRepository.save(ticket);
        assertEquals(1L, ticketRepository.count());
    }
    @Test
    public void TicketSaved_Updating_aNon_SavedTicket_countIsOne() {
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        Ticket ticket2 = new Ticket();
        ticket.setDescription("Test ticket2");
        assertEquals(1L, ticketRepository.count());
    }
    @Test
    public void saveTwoTicket_findTicketById_() {
        assertEquals(0L, ticketRepository.count());
        ticket.setDescription("Test ticket");
        Ticket savedTicket = ticketRepository.save(ticket);
        Ticket ticket2 = new Ticket();
        ticket.setDescription("Test ticket2");
        ticketRepository.save(ticket2);
        Ticket foundTicket = ticketRepository.findById(1);
        assertSame(savedTicket, foundTicket);
    }
    @Test
    public void findNon_ExistingTicket_ById_() {
        assertEquals(0L, ticketRepository.count());
        assertNull(ticketRepository.findById(1));
    }
    @Test
    public void saveTicket_checkIfTicketExistById_() {
        assertEquals(0L, ticketRepository.count());
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        assertTrue(ticketRepository.existsById(1));
    }
    @Test
    public void saveTicket_checkIfTicketExistByNonExisting_Id() {
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        assertFalse(ticketRepository.existsById(2));
    }
    @Test
    public void save2Ticket_findTheTwoTicket() {
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        Ticket ticket2 = new Ticket();
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket2);
        assertEquals(2L, ticketRepository.count());
        assertEquals(2,  ticketRepository.findAll().size());
    }
    @Test
    public void save2ticket_DeleteOneTicket() {
        ticket.setDescription("Test ticket");
        ticketRepository.save(ticket);
        Ticket ticket2 = new Ticket();
        ticket.setDescription("Test ticket2");
        ticketRepository.save(ticket2);
        ticketRepository.deleteById(2);
        assertEquals(1L, ticketRepository.count());
    }

}