package com.agajalam.CurrencyConverter.Week4Homework.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyResponseDTO {
    private Map<String,Double> data;
}
