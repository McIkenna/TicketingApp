package com.hatchway.TicketingApp.serviceInterface;

import com.hatchway.TicketingApp.model.Flight;
import com.hatchway.TicketingApp.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public interface FlightInterface {

    Flight save(Flight flight) throws Exception;
    boolean findByFlightDate(String id);
}
