package com.agajalam.Week5HomeWork.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //log incoming request details
        log.info("incoming request: method={},URI={}",request.getMethod(),request.getRequestURI());

        //continue filter chain
        filterChain.doFilter(request,response);

        // log outgoing response details
        log.info("outgoing Response: {}",response.getStatus());


    }
}
