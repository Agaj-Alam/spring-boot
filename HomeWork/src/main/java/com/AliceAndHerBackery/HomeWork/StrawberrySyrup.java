package com.AliceAndHerBackery.HomeWork;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env" ,havingValue = "strawberry")
class StrawberrySyrup implements Syrup{

    public String getSyrupType() {
        return " strawberry syrup";
    }
}

