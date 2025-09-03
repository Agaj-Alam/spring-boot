package com.agajalam.CurrencyConverter.Week4Homework.controllers;

import com.agajalam.CurrencyConverter.Week4Homework.DTO.ReturnDTO;
import com.agajalam.CurrencyConverter.Week4Homework.clients.impl.CurrencyClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyClientImpl currencyClient;

    @GetMapping("/convertCurrency")
    public ReturnDTO convertCurrency(@RequestParam String fromCurrency,
                                     @RequestParam String toCurrency,
                                     @RequestParam double units){
        double result= currencyClient.convertCurrency(fromCurrency,toCurrency,units);
//        return String.format("Convert %.2f %s to %s = %.2f",units,fromCurrency,toCurrency,result);
        return  ReturnDTO.builder()
                .fromCurrency(fromCurrency)
                .toCurrency(toCurrency)
                .units(units)
                .convertedAmount(result)
                .build();
    }


}
