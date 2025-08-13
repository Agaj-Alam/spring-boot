package com.AliceAndHerBackery.HomeWork;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env" ,havingValue = "strawberry")
class StrawberryFrosting implements Frosting{

    public String getFrostingType() {
        return " strawberry  Frosting";
    }
}
