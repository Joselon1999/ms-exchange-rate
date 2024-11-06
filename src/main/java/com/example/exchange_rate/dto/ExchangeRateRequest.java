package com.example.exchange_rate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ExchangeRateRequest {

    private String originalCurrency;
    private String exchangeCurrency;
    private BigDecimal originalAmount;
}
