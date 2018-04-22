package com.jandagort.game.economy.planet.repository;

import com.jandagort.game.economy.planet.Supply;
import com.jandagort.game.economy.planet.building.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@AllArgsConstructor
public class PlanetEntityFactory {

    private BuildingService buildingService;

    public PlanetEntity getInstance(){

        PlanetEntity planetEntity = new PlanetEntity();

        Supply supply = new Supply();
        Consumption consumption = new Consumption();
        Production production = new Production();
        Population population = new Population();


        planetEntity.setSupply(supply);
        planetEntity.setConsumption(consumption);
        planetEntity.setProduction(production);
        planetEntity.setPopulation(population);

        buildingService.buildVillage(planetEntity, new BigInteger("10"));
        buildingService.buildFarm(planetEntity, new BigInteger("1"));
        buildingService.buildPowerPlant(planetEntity, new BigInteger("1"));

        supply.setFood(new BigInteger("1000"));
        supply.setElectricity(new BigInteger("500"));
        population.setCurrent(new BigInteger("500"));
        consumption.setFood(population.getCurrent());

        return planetEntity;
    }

}
