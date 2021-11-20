package com.hatchway.TicketingApp.serviceInterface;

import com.hatchway.TicketingApp.model.Flight;
import com.hatchway.TicketingApp.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public interface TicketInterface {
    Ticket saveTicket(Ticket ticket) throws Exception;
    Ticket findByTicketId(int id);
    Ticket findBySeatNumber(String id);
}
