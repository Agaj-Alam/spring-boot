package com.codingShuttle.agaj.week1Introduction.introductionToSpringBoot;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component
public class Apple {
    void eatApple(){
        System.out.println("i am eating apple");
    }
@PostConstruct
    void callThisBeforeAppleIsUsed(){
        System.out.println("Creating the apple before use");
    }
    @PreDestroy
    void callThisBeforeAppleIsDestroyed(){
        System.out.println("Destroying the bean");
    }
}
