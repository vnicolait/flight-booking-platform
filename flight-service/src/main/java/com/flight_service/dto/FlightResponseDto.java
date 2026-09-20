package com.flight_service.dto;

import com.flight_service.entity.AirportEntity;
import com.flight_service.entity.Money;
import com.flight_service.entity.StatusFlight;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
@Builder
public class FlightResponseDto {

    private String flightNumber;
    private Money priceFlight;
    private LocalDate departureFlight;
    private LocalDate arriveFlight;
    private AirportEntity from;
    private AirportEntity to;
    private List<SeatEntity> seats;
    private StatusFlight status;
}
