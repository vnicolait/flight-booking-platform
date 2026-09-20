package com.flight_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "seats")
public class SeatEntity {

    @Id
    private UUID id; // for our query in the place of persistence
    private String seatCode;
    private String position; //window/aisle/middle
    private TypeSeat typeSeat;  // VIP, TOURIST, BUSINESS
    private boolean availableSeat;
    @ManyToOne
    @JoinColumn(name = "seats")
    private FlightEntity flight;
}
