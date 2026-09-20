package com.flight_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "airport")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String iata;
    private String name;
    private String city;
    private String country;
    @OneToMany(mappedBy = "to")
    private List<FlightEntity> flightsArrived;
    @OneToMany(mappedBy = "from")
    private List<FlightEntity> flightsDeparture;
}
