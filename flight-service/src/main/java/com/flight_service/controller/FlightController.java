package com.flight_service.controller;


import com.flight_service.dto.FlightResponseDto;
import com.flight_service.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightController {

    FlightService flightService;

    ResponseEntity<List<FlightResponseDto>> listFlights(){
        return ResponseEntity.ok(flightService.totalListOfFlights());
    }
}
