package com.flight_service.service;

import com.flight_service.dto.FlightRequestDto;
import com.flight_service.dto.FlightResponseDto;
import com.flight_service.mapper.FlightMapper;
import com.flight_service.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    private FlightRepository repository;
    private FlightMapper flightMapper;

    public void createFlightService(FlightRequestDto flightRequest){

    }

    public List<FlightResponseDto> totalListOfFlights(){
        return repository.findAll()
                .stream()
                .map(FlightMapper::toDto)
                .toList();


    }
}
