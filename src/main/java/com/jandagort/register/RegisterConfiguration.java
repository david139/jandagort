package com.jandagort.register;

import com.jandagort.game.economy.planet.Consumption;
import com.jandagort.game.economy.planet.Production;
import com.jandagort.game.economy.planet.Supply;
import com.jandagort.game.economy.planet.repository.PlanetEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class RegisterConfiguration {

    @Bean
    @Scope("prototype")
    public PlanetEntity planetEntity(Supply supply, Consumption consumption, Production production) {
        PlanetEntity planetEntity = new PlanetEntity();
        planetEntity.setConsumption(consumption);
        planetEntity.setSupply(supply);
        planetEntity.setProduction(production);

        planetEntity.setUp();

        return planetEntity;
    }


    @Bean
    @Scope("prototype")
    public Supply supply() {
        Supply supply = new Supply();
        supply.setFood(new BigInteger("0"));
        supply.setElectricity(new BigInteger("0"));
        supply.setPopulation(new BigInteger("0"));

        return supply;
    }


    @Bean
    @Scope("prototype")
    public Consumption consumption() {
        Consumption consumption = new Consumption();
        consumption.setFood(new BigInteger("0"));
        consumption.setElectricity(new BigInteger("0"));
        consumption.setPopulation(new BigInteger("0"));

        return consumption;
    }


    @Bean
    @Scope("prototype")
    public Production resources() {
        Production production = new Production();
        production.setFood(new BigInteger("0"));
        production.setElectricity(new BigInteger("0"));
        production.setResidence(new BigInteger("0"));

        return production;
    }

}
