package com.jandagort.game.economy.roundrunner;

import com.jandagort.game.economy.planet.repository.PlanetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@AllArgsConstructor
@Slf4j
public class RoundRunner implements Runnable {
    private PlanetService planetService;

    @Override
    public void run() {
        while (true) {
            try {
                planetService.findAll().forEach(planetEntity -> {
                    planetEntity.stepRound();
                    planetService.save(planetEntity);
                    log.info("population: {}", planetEntity.getPopulation());
                    log.info("food: {}", planetEntity.getFood());
                });
                log.info("Round change happened");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
