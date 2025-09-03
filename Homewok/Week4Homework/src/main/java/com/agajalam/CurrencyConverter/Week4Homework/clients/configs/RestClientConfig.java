package com.agajalam.CurrencyConverter.Week4Homework.clients.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {

    @Value("${currency.client.base.url}")
    private String BASE_URL;

    @Value("${currency.client.api_key}")
    private String API_KEY;

    @Bean
    RestClient restClient(){
            return RestClient.builder()
                    .baseUrl(BASE_URL)
                    .defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)
                    .defaultHeader("apikey",API_KEY)
                    .defaultStatusHandler(HttpStatusCode::is5xxServerError,(req,res)->{
                        throw new RuntimeException("server error occurred");
                    })
                    .build();
    }
}
