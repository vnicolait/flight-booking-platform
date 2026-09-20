package com.flight_service.mapper;

import com.flight_service.dto.FlightResponseDto;
import com.flight_service.entity.FlightEntity;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class FlightMapper {

    public static FlightResponseDto toDto(FlightEntity entity) {
        return FlightResponseDto.builder()
                .flightNumber(entity.getFlightNumber())
                .from(entity.getFrom())
                .to(entity.getTo())
                .departureFlight(entity.getDepartureFlight())
                .arriveFlight(entity.getArriveFlight())
                .build();

    }
}