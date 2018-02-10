package com.jandagort.game.economy;

import com.jandagort.game.economy.planet.repository.PlanetService;
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
            planetEntity.stepRound();
            planetService.save(planetEntity);
        });
        log.info("Round change happened");
    }
}
