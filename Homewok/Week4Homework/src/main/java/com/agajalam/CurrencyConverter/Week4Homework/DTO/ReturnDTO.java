package com.agajalam.CurrencyConverter.Week4Homework.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class ReturnDTO {

    private String fromCurrency;
    private String toCurrency;
    private Double units;
    private Double convertedAmount;

}
