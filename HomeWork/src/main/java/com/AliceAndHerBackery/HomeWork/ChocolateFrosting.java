package com.AliceAndHerBackery.HomeWork;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env" ,havingValue = "chocolate")
public class ChocolateFrosting implements Frosting {

    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}





