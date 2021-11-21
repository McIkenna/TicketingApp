package com.hatchway.TicketingApp.service;

import com.hatchway.TicketingApp.model.Flight;
import com.hatchway.TicketingApp.model.Ticket;
import com.hatchway.TicketingApp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hatchway.TicketingApp.repositories.TicketRepository;
import com.hatchway.TicketingApp.serviceInterface.TicketInterface;

import java.util.Optional;


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
            Ticket ticket1 = findByTicketId(ticket.getTicketId());
            Ticket newTicket = new Ticket();
            if(ticket1 == null){
                if(isSeatPresent(ticket.getSeatNumber(), ticket.getFlightNumber())){
                    System.out.println("Seat already taken");
                }
                else{
                    Flight flight = new Flight();
                    newTicket.setTicketId(ticket.getTicketId());
                    newTicket.setTicketCost(ticket.getTicketCost());
                    newTicket.setSeatNumber(ticket.getSeatNumber());
                    newTicket.setFlightDate(ticket.getFlightDate());
                    newTicket.setFlightNumber(ticket.getFlightNumber());

                    flight.setFlightDate(ticket.getFlightDate());
                    flight.setFlightNumber(ticket.getFlightNumber());
                    flight.getTickets().add(newTicket);
                    newTicket.setFlight(flight);

                    flightRepository.save(flight);
                    return ticketRepository.save(ticket);
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
      return ticketRepository.findByTicketId(id);

    }

    @Override
    public Ticket findBySeatNumber(String id){
        return ticketRepository.findBySeatNumber(id);
    }

    public Ticket findByFlightName(String id){
        return ticketRepository.findByFlightNumber(id);
    }


    public Boolean isSeatPresent(String seatNumber, String flightNumber){
        Ticket ticket = ticketRepository.findByFlightNumber(flightNumber);
        if(ticket == null){
            return false;
        }
        else if(ticket.getSeatNumber().equals(seatNumber)){
            return true;
        }else
        {
            return false;
        }
    }
}
