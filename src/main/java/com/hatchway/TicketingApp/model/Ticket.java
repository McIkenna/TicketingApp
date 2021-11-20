package com.hatchway.TicketingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    private int ticketId;
    private String seatNumber;
    private int ticketCost;
    private String flightNumber;
    private String flightDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    @JsonIgnore
    private Flight flight;

}
