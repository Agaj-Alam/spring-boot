package com.IntroductionToSpringBoot.weak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppleConfig {
    @Bean
    @Scope("prototype")
    com.codingShuttle.agaj.week1Introduction.introductionToSpringBoot.Apple getApple(){
        return  new com.codingShuttle.agaj.week1Introduction.introductionToSpringBoot.Apple();
    }
}
