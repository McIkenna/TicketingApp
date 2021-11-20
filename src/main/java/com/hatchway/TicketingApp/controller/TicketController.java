package com.hatchway.TicketingApp.controller;

import com.hatchway.TicketingApp.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hatchway.TicketingApp.serviceInterface.TicketInterface;

import javax.naming.Binding;

@RestController
@SpringBootApplication
@RequestMapping("/api/tickets")
@CrossOrigin
public class TicketController {

    @Autowired
    TicketInterface ticketService;

    @PostMapping("")
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) throws Exception {
        Ticket newTicket = ticketService.saveTicket(ticket);
        return new ResponseEntity<Ticket>(newTicket, HttpStatus.CREATED);
    }
}
