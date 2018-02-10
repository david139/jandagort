package com.jandagort.register;

import com.jandagort.game.economy.planet.repository.PlanetEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class RegisterConfiguration {

    @Bean
    @Scope("prototype")
    public PlanetEntity planetEntity() {
        PlanetEntity planetEntity = new PlanetEntity();
        return planetEntity;
    }
}
