package com.jandagort.game.economy;

import com.jandagort.game.economy.planet.repository.PlanetEntity;
import com.jandagort.game.economy.planet.repository.PlanetService;
import com.jandagort.util.BigIntegerUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@AllArgsConstructor
@Slf4j
public class RoundRunner {
    private PlanetService planetService;

    @Scheduled(fixedRate = 1000)
    public void run() {
        planetService.findAll().forEach(planetEntity -> {
            stepRound(planetEntity);
            planetService.save(planetEntity);
        });
        log.info("Round change happened");
    }


    private void stepRound(PlanetEntity entity) {
        entity.getSupply().setElectricity(entity.getSupply().getElectricity().add(entity.getProduction().getElectricity()));
        entity.getSupply().setFood(entity.getSupply().getFood().subtract(entity.getConsumption().getFood()));
        entity.getPopulation().setCurrent(BigIntegerUtil.incrementWithPercentage(entity.getPopulation().getCurrent(), 10));
        entity.getConsumption().setFood(entity.getPopulation().getCurrent());
    }

}
