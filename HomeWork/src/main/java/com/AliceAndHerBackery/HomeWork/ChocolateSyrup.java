package com.AliceAndHerBackery.HomeWork;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env" ,havingValue = "chocolate")
class ChocolateSyrup implements Syrup{

    public String getSyrupType() {
        return " Chocolate Syrup";
    }
}
