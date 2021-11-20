package com.hatchway.TicketingApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;
    private String flightNumber;
    private String flightDate;
    @OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<>();
}
