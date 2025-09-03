package com.agajalam.CurrencyConverter.Week4Homework.clients.impl;

import com.agajalam.CurrencyConverter.Week4Homework.DTO.CurrencyResponseDTO;
import com.agajalam.CurrencyConverter.Week4Homework.clients.CurrencyClient;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CurrencyClientImpl implements CurrencyClient {
    private final RestClient restClient;

    Logger log= LoggerFactory.getLogger(CurrencyClientImpl.class);


    @Override
    public double convertCurrency(String fromCurrency, String toCurrency, double units) {
        log.trace("Trying to convert {} {} to {}",units,fromCurrency,toCurrency);
        try{
            log.info("calling External currency api ...");

            CurrencyResponseDTO response=restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/latest")
                            .queryParam("base_currency",fromCurrency)
                            .queryParam("currencies",toCurrency)
                            .build())
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error("4xx error: {}",new String(res.getBody().readAllBytes()));
                        throw new RuntimeException("Invalid request to currency API");
                    })
                    .body(new ParameterizedTypeReference<CurrencyResponseDTO>() {
                    });
            log.debug("API response received successfully");
            double rate=response.getData().get(toCurrency);
            double convertedAmount=units*rate;

            log.trace("Result: {} {}={} {}",units,fromCurrency,convertedAmount,toCurrency);
            return convertedAmount;
        }
        catch (Exception e){
            log.error("Exception in convertCurrency: {}",e.getMessage(),e);
            throw new RuntimeException("currency conversion failed",e);

        }
    }
}
