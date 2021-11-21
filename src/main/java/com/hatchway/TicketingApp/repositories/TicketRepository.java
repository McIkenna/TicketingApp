package com.hatchway.TicketingApp.repositories;

import com.hatchway.TicketingApp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findByTicketId(int id);
    Ticket findBySeatNumber(String id);
    Ticket findByFlightNumber(String id);

}
