package com.hatchway.TicketingApp.service;

import com.hatchway.TicketingApp.model.Flight;
import com.hatchway.TicketingApp.repositories.FlightRepository;
import com.hatchway.TicketingApp.serviceInterface.FlightInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService implements FlightInterface {

    @Autowired
    FlightRepository flightRepository;
    @Override
    public Flight save(Flight flight) throws Exception {

        return flightRepository.save(flight);
    }



    @Override
    public boolean findByFlightDate(String id) {
        return false;
    }
}
