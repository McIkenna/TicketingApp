package com.hatchway.TicketingApp.service;

import com.hatchway.TicketingApp.model.Flight;
import com.hatchway.TicketingApp.model.Ticket;
import com.hatchway.TicketingApp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hatchway.TicketingApp.repositories.TicketRepository;
import com.hatchway.TicketingApp.serviceInterface.TicketInterface;



@Service
public class TicketService implements TicketInterface {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    FlightService flightService;
    @Autowired
    FlightRepository flightRepository;
    //private  int id = 0;

    @Override
    public Ticket saveTicket(Ticket ticket) throws Exception {

        try {
            Ticket ticket1 = ticketRepository.findByTicketId(ticket.getTicketId());
            Ticket ticketBySeat = ticketRepository.findBySeatNumber(ticket.getSeatNumber());
           // Ticket ticketByFlightNumber = ticketRepository.findByFlightNumber(ticket.getFlightNumber());
            if(ticket1 == null){
            Flight flight = new Flight();
            if(ticketBySeat.getFlightNumber().equals(ticket.getFlightNumber())) {
                    flight.setFlightDate(ticket.getFlightDate());
                    flight.setFlightNumber(ticket.getFlightNumber());
                    flight.getTickets().add(ticket);
                    ticket.setFlight(flight);
                    flightRepository.save(flight);
                    return ticketRepository.save(ticket);
            }
            else{
                    System.out.println("This seat already exist");
            }
            }
            else {
                System.out.println("Ticket already exist");
            }
            //flightService.save(flight);
            return null;
            }catch(Exception ex){
                throw new Exception("Something happened" + ex);
            }
        }

    @Override
    public Ticket findByTicketId(int id){
        Ticket ticket = ticketRepository.findByTicketId(id);
            return ticket;
    }

    @Override
    public Ticket findBySeatNumber(String id){
        Ticket ticket = ticketRepository.findBySeatNumber(id);
            return ticket;
    }

    public Ticket findByFlightName(String id){
        return ticketRepository.findByFlightNumber(id);
    }
}
