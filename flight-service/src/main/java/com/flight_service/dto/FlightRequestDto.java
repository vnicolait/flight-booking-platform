package com.flight_service.dto;

import com.flight_service.entity.AirportEntity;
import com.flight_service.entity.Money;
import com.flight_service.entity.StatusFlight;

import java.time.LocalDate;
import java.util.List;

public class FlightRequestDto {

    private String flightNumber;
    private Money priceFlight;
    private LocalDate departureFlight;
    private LocalDate arriveFlight;
    private AirportEntity from;
    private AirportEntity to;
    private List<SeatEntity> seats;
    StatusFlight status;
}
