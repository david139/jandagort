package com.jandagort.game.economy.planet.building;

import com.jandagort.game.economy.planet.repository.PlanetEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class BuildingService {

    public void buildFarm(PlanetEntity entity, BigInteger amount) {
        increment(entity::getFarms, entity::setFarms, amount);
        increment(() -> entity.getProduction().getFood(),
                a -> entity.getProduction().setFood(a),
                Farm.FOOD_PRODUCTION.getValue().multiply(amount));

        increment(() -> entity.getConsumption().getElectricity(),
                a -> entity.getConsumption().setElectricity(a),
                Farm.ELECTRICITY_CONSUMPTION.getValue().multiply(amount));

        increment(() -> entity.getPopulation().getAllocated(),
                a -> entity.getPopulation().setAllocated(a),
                Farm.POPULATION_ALLOCATION.getValue().multiply(amount));
    }

    public void buildPowerPlant(PlanetEntity entity, BigInteger amount) {
        increment(entity::getPowerPlants, entity::setPowerPlants, amount);
        increment(() -> entity.getProduction().getElectricity(),
                a -> entity.getProduction().setElectricity(a),
                PowerPlant.ENERGY_PRODUCTION.getValue().multiply(amount));

        increment(() -> entity.getPopulation().getAllocated(),
                a -> entity.getPopulation().setAllocated(a),
                PowerPlant.POPULATION_ALLOCATION.getValue().multiply(amount));
    }

    public void buildVillage(PlanetEntity entity, BigInteger amount) {
        increment(entity::getVillages, entity::setVillages, amount);

        increment(() -> entity.getPopulation().getMax(),
                a -> entity.getPopulation().setMax(a),
                Village.RESIDENCE.getValue().multiply(amount));
    }

    public void increment(Supplier<BigInteger> getter, Consumer<BigInteger> setter, BigInteger amount) {
        BigInteger current = getter.get();

        if(current == null){
            current = new BigInteger("0");
        }

        setter.accept(current.add(amount));
    }

}
