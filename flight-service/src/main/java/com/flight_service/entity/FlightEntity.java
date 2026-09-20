package com.flight_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "flights")
public class FlightEntity {

    @Id
    private UUID ID;
    private String flightNumber;
    private Money priceFlight;
    private LocalDate departureFlight;
    private LocalDate arriveFlight;
    @ManyToOne
    @JoinColumn(name = "airport_from_id", nullable = false)
    private AirportEntity from;
    @ManyToOne
    @JoinColumn(name = "airport_to_id", nullable = false)
    private AirportEntity to;
    @OneToMany
    @JoinColumn(name = "flight")
    private List<SeatEntity> seats;
    StatusFlight status;
}
