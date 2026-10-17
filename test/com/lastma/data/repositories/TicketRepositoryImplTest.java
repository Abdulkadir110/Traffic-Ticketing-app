package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import com.lastma.data.models.ViolationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryImplTest {

    private TicketRepositoryImpl ticketRepository;
    private Ticket ticket;

    @BeforeEach
    public void startWith() {
        ticketRepository = new TicketRepositoryImpl();
        ticket = new Ticket();
    }
    @Test
    public void test_save_ticket_count_is_one(){
        ticketRepository.save(ticket);
        assertEquals(1L, ticketRepository.count());
    }
    @Test
    public void test_save_two_tickets_count_is_two(){
        Ticket ticket2 = new Ticket();
        ticketRepository.save(ticket);
        ticketRepository.save(ticket2);
        assertEquals(2L, ticketRepository.count());
    }
    @Test
    public void test_save_ticket_ableToGetTicketId(){
        ticketRepository.save(ticket);
        assertEquals(1, ticket.getId());
    }
    @Test
    public void test_save_ticket_CheckIfTheTicketISaved_isWhatIGot(){
        Ticket savedTicket = ticketRepository.save(ticket);
        assertEquals(ticket, savedTicket);
    }
    @Test
    public void saveTicket_finditById(){
        Ticket savedTicket = ticketRepository.save(ticket);
        assertEquals(savedTicket, ticketRepository.findById(1));
    }
    @Test
    public void saveTicket_findWithAWrongId_returnsNull(){
        ticketRepository.save(ticket);
        assertNull(ticketRepository.findById(-1));
    }
    @Test
    public void saveTicket_getTicket_IssuedDate(){
        Ticket savedTicket = ticketRepository.save(ticket);
        assertEquals(savedTicket.getIssuedDate(),  ticket.getIssuedDate());
    }
    @Test
    public void saveTicket_set_violationType_updateTicket_ViolationType_and_Fee(){
        ticket.setType(ViolationType.ONE_WAY);
        Ticket savedTicket = ticketRepository.save(ticket);
        savedTicket.setType(ViolationType.EXPIRED_PAPERS);
        assertEquals(ViolationType.EXPIRED_PAPERS, ticket.getType());
    }
    @Test
    public void saveTwoTicket_DeleteOne_CountIsOne(){
        ticketRepository.save(ticket);
        Ticket ticket2 = new Ticket();
        ticketRepository.save(ticket2);
        assertEquals(2L, ticketRepository.count());
        ticketRepository.deleteById(1);
        assertEquals(1L, ticketRepository.count());
    }
    @Test
    public void saveTwoTicket_DeleteTicketById_CountIsOne(){
        ticketRepository.save(ticket);
        Ticket ticket2 = new Ticket();
        ticketRepository.save(ticket2);
        assertEquals(2L, ticketRepository.count());
        ticketRepository.deleteById(1);
        assertEquals(1L, ticketRepository.count());
    }

}