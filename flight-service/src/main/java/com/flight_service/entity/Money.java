package com.flight_service.entity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class Money {

    private BigDecimal amount;
    private String currency;

    public Money add(Money other){
     if(this.currency.equals(other.currency)){
         throw new IllegalArgumentException("You cannot add diferent currencies together");
     }
     return new Money(this.amount.add(other.amount), this.currency);
    }

}
