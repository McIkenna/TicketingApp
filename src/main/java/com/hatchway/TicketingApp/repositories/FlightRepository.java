package com.hatchway.TicketingApp.repositories;

import com.hatchway.TicketingApp.model.Flight;
import com.hatchway.TicketingApp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightDate(String id);
    Flight findByFlightNumber(String id);
}
